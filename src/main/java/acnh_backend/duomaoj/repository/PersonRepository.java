package acnh_backend.duomaoj.repository;

import acnh_backend.duomaoj.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {
}
