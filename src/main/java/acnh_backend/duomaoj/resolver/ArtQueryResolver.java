package acnh_backend.duomaoj.resolver;

import acnh_backend.duomaoj.model.Art;
import acnh_backend.duomaoj.repository.ArtRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Service;

@Service
public class ArtQueryResolver implements GraphQLQueryResolver {
    private ArtRepository artRepository;

    public ArtQueryResolver(ArtRepository artRepository) {
        this.artRepository = artRepository;
    }

    public Iterable<Art> findAllArts() {
        return artRepository.findAll();
    }

    public Iterable<Art> findArtsByTag(String tag) {
        return artRepository.findByTag(tag);
    }
}
