package acnh_backend.duomaoj.repository;

import acnh_backend.duomaoj.model.Recipe;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface RecipeRepository extends MongoRepository<Recipe, String> {
    @Query("{'_id' : ?0}")
    Recipe findRecipeById(ObjectId id);
    @Query("{'internalId' :{$in: ?0}}")
    Iterable<Recipe> findAllByInternalId(int[] ids);
    @Query("{'craftedId': ?0}")
    Recipe findRecipeByItem(int itemId);
    @Query("{'_id': {'$gt': ?0}}")
    Iterable<Recipe> findRecipeAfter(ObjectId after);
}
