package acnh_backend.duomaoj.repository;

import acnh_backend.duomaoj.model.Material;
import acnh_backend.duomaoj.type.Item;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface MaterialRepository extends MongoRepository<Material, String> {
    @Query("{'_id' : ?0}")
    Material findMaterialById(ObjectId id);
    @Query("{'_id': {'$gt': ?0}}")
    Iterable<Material> findMaterialAfter(ObjectId after);
    @Query("{'internalId': ?0}")
    Item findMaterialByInternalId(int internalId);

}
