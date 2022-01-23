package acnh_backend.duomaoj.resolver;

import acnh_backend.duomaoj.model.Umbrella;
import acnh_backend.duomaoj.repository.UmbrellaRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
public class UmbrellaQueryResolver implements GraphQLQueryResolver {
    private UmbrellaRepository umbrellaRepository;

    public UmbrellaQueryResolver(UmbrellaRepository umbrellaRepository) {
        this.umbrellaRepository = umbrellaRepository;
    }

    public Iterable<Umbrella> findAllUmbrellas() {
        return umbrellaRepository.findAll();
    }

    public Umbrella findUmbrellaById(String id) {
        ObjectId oid = new ObjectId(id);
        return umbrellaRepository.findById(oid);
    }
}
