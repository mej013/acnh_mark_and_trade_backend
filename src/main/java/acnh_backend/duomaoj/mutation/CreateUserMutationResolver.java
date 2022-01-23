package acnh_backend.duomaoj.mutation;

/*import acnh_backend.duomaoj.model.User;
import acnh_backend.duomaoj.repository.UserRepository;

import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Service;
//import org.springframework.security.crypto.bcrypt.*;

@Service
public class CreateUserMutationResolver implements GraphQLMutationResolver {
    private UserRepository userRepository;
    private static final int EXPIRY_HOURS = 1;
    public CreateUserMutationResolver(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String email, String pwd, String uname) {
        User existingUser = userRepository.findByEmail(email);
        if (existingUser != null) {
            throw new Error("User exists already. Please log in.");
        }
        //BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //String hashedPwd = encoder.encode(pwd);
        User user = new User(email, pwd, uname);
        userRepository.save(user);
        return user;
    }

    public boolean deleteUser(String id) {
        userRepository.deleteById(id);
        return true;
    }


}*/
