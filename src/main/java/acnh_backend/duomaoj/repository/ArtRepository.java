package acnh_backend.duomaoj.repository;

import acnh_backend.duomaoj.model.Creature;
import org.springframework.data.mongodb.repository.MongoRepository;

import acnh_backend.duomaoj.model.Art;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ArtRepository extends MongoRepository<Art, String> {
    @Query("{'tag' : ?0}")
    List<Art> findByTag(String tag);
}
