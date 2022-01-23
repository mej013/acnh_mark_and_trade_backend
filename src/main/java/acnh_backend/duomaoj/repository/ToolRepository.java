package acnh_backend.duomaoj.repository;

import acnh_backend.duomaoj.model.Tool;
import acnh_backend.duomaoj.type.Item;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ToolRepository extends MongoRepository<Tool, String> {
    @Query("{'_id' : ?0}")
    Tool findToolById(ObjectId id);
    @Query("{'internalId': ?0}")
    Item findToolByInternalId(int internalId);

}
