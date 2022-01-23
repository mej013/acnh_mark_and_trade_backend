package acnh_backend.duomaoj.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acnh_backend.duomaoj.model.Creature;
import acnh_backend.duomaoj.repository.CreatureRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;

@Service
public class CreatureQueryResolver implements GraphQLQueryResolver {
    private CreatureRepository creatureRepository;

    @Autowired
    public CreatureQueryResolver(CreatureRepository creatureRepository) {
        this.creatureRepository = creatureRepository;
    }

    public Iterable<Creature> findAllCreatures() {
        return creatureRepository.findAll();
    }

    public Iterable<Creature> findCreaturesByCategory(String category) {
        return creatureRepository.findByCategory(category);
    }
}
