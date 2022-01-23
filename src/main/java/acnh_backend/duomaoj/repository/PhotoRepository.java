package acnh_backend.duomaoj.repository;

import acnh_backend.duomaoj.model.Photo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PhotoRepository extends MongoRepository<Photo, String> {
    @Query("{'_id' : ?0}")
    Photo findPhotoById(ObjectId id);
    @Query("{'internalId' : ?0}")
    Photo findPhotoByInternalId(int internalId);
}
