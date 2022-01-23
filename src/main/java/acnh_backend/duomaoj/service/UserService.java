package acnh_backend.duomaoj.service;

import acnh_backend.duomaoj.model.Person;
import acnh_backend.duomaoj.model.User;
import acnh_backend.duomaoj.repository.PersonRepository;
import acnh_backend.duomaoj.repository.UserRepository;
import acnh_backend.duomaoj.security.JWTUserDetails;
import acnh_backend.duomaoj.security.exception.BadCredentialsException;
import acnh_backend.duomaoj.security.exception.BadTokenException;
import acnh_backend.duomaoj.security.exception.UserAlreadyExistsException;
import acnh_backend.duomaoj.security.exception.UserNotFoundException;
import acnh_backend.duomaoj.type.CreateUserInput;
import acnh_backend.duomaoj.security.*;
import acnh_backend.duomaoj.type.UpdatePasswordInput;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.Instant;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static acnh_backend.duomaoj.StreamUtils.collectionStream;
import static java.util.function.Predicate.not;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private static final String ADMIN_AUTHORITY = "ADMIN";
    private static final String USER_AUTHORITY = "USER";
    private final UserRepository userRepository;
    private final PersonRepository personRepository;
    private final SecurityProperties properties;
    private final Algorithm algorithm;
    private final JWTVerifier verifier;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public JWTUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .map(user->getUserDetails(user, getToken(user)))
                .orElseThrow(() -> new UsernameNotFoundException("Username or password doesn't match"));
    }


    @Transactional
    public JWTUserDetails loadUserByToken(String token) {
        //System.out.println(token);
        return getDecodedToken(token)
                .map(DecodedJWT::getSubject)
                .flatMap(userRepository::findByEmail)
                .map(user -> getUserDetails(user, token))
                .orElseThrow(BadTokenException::new);
    }

    @Transactional
    public User getCurrentUser() {
        return Optional
                .ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .map(Authentication::getName)
                .flatMap(userRepository::findByEmail)
                .orElse(null);
    }

    @Transactional
    public User createUser(CreateUserInput input, Person person) {
        if(!exists(input)) {
            User user = User
                    .builder()
                    .email(input.getEmail())
                    .pwd(passwordEncoder.encode(input.getPassword()))
                    .roles(Set.of(USER_AUTHORITY))
                    .person(person)
                    .personId(person.get_id())
                    .build();
            userRepository.save(user);
            return user;
        } else {
            personRepository.deleteById(person.get_id().toString());
            throw new UserAlreadyExistsException(input.getEmail());
        }
    }

    @Transactional
    public User updatePassword(ObjectId userId, UpdatePasswordInput input) {
        User user = userRepository.findById(userId.toString()).orElseThrow(()->new UserNotFoundException(userId.toString()));
        if (passwordEncoder.matches(input.getOriginalPassword(), user.getPwd())) {
            user.setPwd(passwordEncoder.encode((input.getNewPassword())));
        } else {
            throw new BadCredentialsException(user.getEmail());
        }
        return user;
    }

    @Transactional
    public String getToken(User user) {
        Instant now = Instant.now();
        Instant expiry = Instant.now().plus(properties.getTokenExpiration());
        return JWT
                .create()
                .withIssuer(properties.getTokenIssuer())
                .withIssuedAt(Date.from(now))
                .withExpiresAt(Date.from(expiry))
                .withSubject(user.getEmail())
                .sign(algorithm);
    }

    public Optional<User> findUserById(String id) {
        return userRepository.findById(id);
    }

    public boolean isAdmin() {
        return Optional
                .ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .map(Authentication::getAuthorities)
                .stream()
                .flatMap(Collection::stream)
                .map(GrantedAuthority::getAuthority)
                .anyMatch(ADMIN_AUTHORITY::equals);
    }


    public boolean isAuthenticated() {
        return Optional
                .ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .filter(Authentication::isAuthenticated)
                .filter(not(this::isAnonymous))
                .isPresent();
    }

    private boolean isAnonymous(Authentication authentication) {
        return authentication instanceof AnonymousAuthenticationToken;
    }


    @Transactional
    public boolean deleteUser(String id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    private boolean exists(CreateUserInput input) {
        return userRepository.existsByEmail(input.getEmail());
    }

    private JWTUserDetails getUserDetails(User user, String token) {
        return JWTUserDetails
                .builder()
                .username(user.getEmail())
                .password(user.getPwd())
                .authorities(collectionStream(user.getRoles())
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList()))
                .token(token)
                .build();
    }

    private Optional<DecodedJWT> getDecodedToken(String token) {
        try {
            return Optional.of(verifier.verify(token));
        } catch(JWTVerificationException ex) {
            return Optional.empty();
        }
    }


}
