package acnh_backend.duomaoj.resolver;


import acnh_backend.duomaoj.service.UserService;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;


import acnh_backend.duomaoj.model.User;

@Component
@RequiredArgsConstructor
public class UserResolver implements GraphQLResolver<User> {
    private final UserService service;

    @PreAuthorize("isAuthenticated()")
    public String getToken(User user) {
        return service.getToken(user);
    }
}


/*
@Service
public class UserQueryResolver implements GraphQLQueryResolver<User> {
    private UserRepository userRepository;
    private static final int EXPIRY_HOURS = 1;

    @Autowired
    public UserQueryResolver(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }

    /*
    public AuthData login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new Error("Invalid credentials!");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        boolean matched = encoder.matches(password, user.getPwd());
        if (!matched) {
            System.out.println("not matched");
            throw new Error("Invalid credentials!");
        }


        LocalDateTime issued = LocalDateTime.now();
        LocalDateTime exp = LocalDateTime.now().plusHours(EXPIRY_HOURS);
        String jws = Jwts.builder().claim("userId", user.getId())
                .claim("email", user.getEmail())
                .setIssuedAt(Date.from(Instant.ofEpochSecond(issued.toEpochSecond(ZoneOffset.UTC))))
                .setExpiration(Date.from(Instant.ofEpochSecond(exp.toEpochSecond(ZoneOffset.UTC))))
                .signWith(
                        SignatureAlgorithm.HS256,
                        "secret".getBytes(StandardCharsets.UTF_8)
                )
        .toString();

        AuthData authData = new AuthData();
        authData.setToken(jws);
        authData.setUserId(user.getId());
        authData.setTokenExpiration(EXPIRY_HOURS);
        return authData;
    }}*/
