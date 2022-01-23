package acnh_backend.duomaoj.resolver;

import acnh_backend.duomaoj.model.Person;
import acnh_backend.duomaoj.model.User;
import acnh_backend.duomaoj.service.UserService;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PersonResolver implements GraphQLResolver<Person> {
    private final UserService userService;

    public String getEmail(Person person) {
        return userService.isAuthenticated() && person.getUser() != null ? person.getUser().getEmail() : null;
    }

    public Collection<String> getRoles(Person person) {
        Optional<User> user = userService.findUserById(person.get_id().toString());
        return user.get().getRoles();
    }

}
