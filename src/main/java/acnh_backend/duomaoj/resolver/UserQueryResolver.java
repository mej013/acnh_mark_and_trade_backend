package acnh_backend.duomaoj.resolver;

import acnh_backend.duomaoj.model.User;
import acnh_backend.duomaoj.service.UserService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserQueryResolver implements GraphQLQueryResolver{
    private final UserService userService;

    public User getCurrentUser() {
        return userService.getCurrentUser();
    }

}
