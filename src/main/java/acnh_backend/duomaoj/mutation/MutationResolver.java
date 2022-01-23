package acnh_backend.duomaoj.mutation;

import acnh_backend.duomaoj.model.Person;
import acnh_backend.duomaoj.model.User;
import acnh_backend.duomaoj.security.exception.UserAlreadyExistsException;
import acnh_backend.duomaoj.service.PersonService;
import acnh_backend.duomaoj.service.UserService;
import acnh_backend.duomaoj.type.CreatePersonInput;
import acnh_backend.duomaoj.type.CreateUserInput;
import acnh_backend.duomaoj.type.UpdatePasswordInput;
import acnh_backend.duomaoj.type.UpdatePersonInput;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MutationResolver implements GraphQLMutationResolver {
    private final UserService userService;
    private final PersonService personService;
    private final AuthenticationProvider authenticationProvider;

    public User createUser(CreateUserInput userInput, CreatePersonInput personInput) {
        Person person = personService.create(personInput);
        return userService.createUser(userInput, person);
    }

    @PreAuthorize("isAuthenticated()")
    public User updatePassword(UpdatePasswordInput input) {
        return userService.updatePassword(userService.getCurrentUser().getPersonId(), input);
    }

    @PreAuthorize("isAuthenticated()")
    public Boolean markItem(String userId, int internalId) {
        List<Integer> marked = personService.getById(userId).getMarkedItems() != null ? personService.getById(userId).getMarkedItems():
                new ArrayList<Integer>();
        if(marked.contains(internalId)) {
            return false;
        } else {
            marked.add(internalId);
            personService.updateMarked(userId, marked);
            //System.out.println(personService.getById(userId).getHemisphere());
            return true;
        }
    }

    //@PreAuthorize("isAuthenticated()")
    public Boolean unmarkItem(String userId, int internalId) {
        List<Integer> marked = personService.getById(userId).getMarkedItems();
        if (marked == null) {
            return false;
        } else if (marked.contains(internalId) == false) {
            return false;
        } else {
            marked.remove(Integer.valueOf(internalId));
            personService.updateMarked(userId, marked);
            return true;
        }
     }

    @PreAuthorize("isAuthenticated()")
    public Person updatePerson(UpdatePersonInput input) {
        return personService.update(userService.getCurrentUser().getPersonId(), input);
    }

    @PreAuthorize("isAnonymous()")
    public User login(String email, String password) {
        UsernamePasswordAuthenticationToken credentials = new UsernamePasswordAuthenticationToken(email, password);
        try {
            SecurityContextHolder.getContext().setAuthentication(authenticationProvider.authenticate(credentials));
            return userService.getCurrentUser();
        } catch (AuthenticationException ex) {
            System.out.println("exception!!!!!!!!!!!!");
            throw new BadCredentialsException(email);
        }
    }

    @PreAuthorize("isAuthenticated()")
    public boolean deleteUser(String personId){
        return userService.deleteUser(personId);
    }


}
