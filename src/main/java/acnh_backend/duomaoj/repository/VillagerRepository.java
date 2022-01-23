package acnh_backend.duomaoj.repository;

import acnh_backend.duomaoj.model.Villager;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface VillagerRepository extends MongoRepository<Villager, String> {
    @Query("{'_id' : ?0}")
    Villager findVillagerById(ObjectId id);
    @Query("{'internalId' : ?0}")
    Villager findVillagerByInternalId(int internalId);
}
