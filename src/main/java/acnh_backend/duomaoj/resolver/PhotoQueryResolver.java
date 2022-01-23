package acnh_backend.duomaoj.resolver;

import acnh_backend.duomaoj.model.Photo;
import acnh_backend.duomaoj.repository.PhotoRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PhotoQueryResolver implements GraphQLQueryResolver {
    private PhotoRepository photoRepository;

    public Iterable<Photo> findAllPhotos() {
        return photoRepository.findAll();
    }

    public Photo findPhotoById(String id) {
        ObjectId oid = new ObjectId(id);
        return photoRepository.findPhotoById(oid);
    }
}
