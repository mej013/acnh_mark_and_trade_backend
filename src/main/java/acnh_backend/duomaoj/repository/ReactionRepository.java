package acnh_backend.duomaoj.repository;

import acnh_backend.duomaoj.model.Reaction;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ReactionRepository extends MongoRepository<Reaction, String> {
    @Query("{'_id' : ?0}")
    Reaction findReactionById(ObjectId id);
    @Query("{'internalId' : ?0}")
    Reaction findReactionByInternalId(int internalId);
}
