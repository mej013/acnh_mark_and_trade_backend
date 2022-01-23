package acnh_backend.duomaoj.repository;

import acnh_backend.duomaoj.model.Food;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface FoodRepository extends MongoRepository<Food, String> {
    @Query("{'_id': ?0}")
    Food findFoodById(ObjectId id);
    @Query("{'internalId': ?0}")
    Food findFoodByInternalId(int internalId);
}
