package acnh_backend.duomaoj.repository;

import acnh_backend.duomaoj.model.Music;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface MusicRepository extends MongoRepository<Music, String> {
    @Query("{'_id' : ?0}")
    Music findMusicById(ObjectId id);
    @Query("{'internalId' : ?0}")
    Music findMusicByInternalId(int internalId);
    @Query("{'name' : ?0}")
    Music findMusicByName(String name);


}
