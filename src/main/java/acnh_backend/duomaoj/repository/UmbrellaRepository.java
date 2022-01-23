package acnh_backend.duomaoj.repository;

import acnh_backend.duomaoj.model.Umbrella;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UmbrellaRepository extends MongoRepository<Umbrella, String> {
    @Query("{'_id' : ?0}")
    Umbrella findById(ObjectId id);
}
