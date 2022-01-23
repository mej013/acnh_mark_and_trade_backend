package acnh_backend.duomaoj.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import acnh_backend.duomaoj.model.User;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    @Query("{'email' : ?0}")
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
