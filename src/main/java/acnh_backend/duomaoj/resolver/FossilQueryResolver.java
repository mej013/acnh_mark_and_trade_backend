package acnh_backend.duomaoj.resolver;

import acnh_backend.duomaoj.model.Fossil;
import acnh_backend.duomaoj.repository.FossilRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Service;

@Service
public class FossilQueryResolver implements GraphQLQueryResolver {
    private FossilRepository fossilRepository;

    public FossilQueryResolver(FossilRepository fossilRepository) {
        this.fossilRepository = fossilRepository;
    }

    Iterable<Fossil> findAllFossils() {
        return fossilRepository.findAll();
    }
}
