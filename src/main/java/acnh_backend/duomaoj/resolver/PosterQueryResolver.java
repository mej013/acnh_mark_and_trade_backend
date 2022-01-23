package acnh_backend.duomaoj.resolver;

import acnh_backend.duomaoj.model.Poster;
import acnh_backend.duomaoj.repository.PosterRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PosterQueryResolver implements GraphQLQueryResolver {
    private PosterRepository posterRepository;

    public Iterable<Poster> findAllPosters() {
        return posterRepository.findAll();
    }

    public Poster findPosterById(String id) {
        ObjectId oid = new ObjectId(id);
        return posterRepository.findPosterById(oid);
    }
}
