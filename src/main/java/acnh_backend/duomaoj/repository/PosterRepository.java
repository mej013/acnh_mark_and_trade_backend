package acnh_backend.duomaoj.repository;

import acnh_backend.duomaoj.model.Poster;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PosterRepository extends MongoRepository<Poster, String> {
    @Query("{'_id' : ?0}")
    Poster findPosterById(ObjectId id);
    @Query("{'internalId' : ?0}")
    Poster findPosterByInternalId(int internalId);

}
