package acnh_backend.duomaoj.repository;

import acnh_backend.duomaoj.model.Fossil;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FossilRepository extends MongoRepository<Fossil, String> {
}
