package acnh_backend.duomaoj.repository;

import acnh_backend.duomaoj.model.Clothes;
import acnh_backend.duomaoj.type.Item;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ClothesRepository extends MongoRepository<Clothes, String> {
    @Query("{'_id': {'$gt': ?0}}")
    Iterable<Clothes> findClothesAfter(ObjectId after);
    @Query("{'_id' : ?0}")
    Clothes findClothesById(ObjectId id);
    @Query("{'category' : ?0}")
    List<Clothes> findByCategory(String category);
    @Query("{'internalId' : ?0}")
    Item findClothesByInternalId(int internalId);

}
