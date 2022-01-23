package acnh_backend.duomaoj.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import acnh_backend.duomaoj.model.Creature;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CreatureRepository extends MongoRepository<Creature, String> {
    @Query("{'category' : ?0}")
    List<Creature> findByCategory(String category);
}
