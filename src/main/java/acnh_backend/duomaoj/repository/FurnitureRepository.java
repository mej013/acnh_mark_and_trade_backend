package acnh_backend.duomaoj.repository;

import acnh_backend.duomaoj.model.Creature;
import acnh_backend.duomaoj.model.Furniture;
import acnh_backend.duomaoj.type.FurnitureConnection;
import acnh_backend.duomaoj.type.Item;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface FurnitureRepository extends MongoRepository<Furniture, String> {
    @Query("{'_id' : ?0}")
    Furniture findFurnitureById(ObjectId id);
    @Query("{'_id': {'$gt': ?0}}")
    Iterable<Furniture> findFurnitureAfter(ObjectId after);
    @Query("{'internalId': ?0}")
    Item findFurnitureByInternalId(int internalId);
}
