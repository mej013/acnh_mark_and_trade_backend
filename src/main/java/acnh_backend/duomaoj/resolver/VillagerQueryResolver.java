package acnh_backend.duomaoj.resolver;

import acnh_backend.duomaoj.model.Villager;
import acnh_backend.duomaoj.repository.VillagerRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
public class VillagerQueryResolver implements GraphQLQueryResolver {
    private VillagerRepository villagerRepository;
    public VillagerQueryResolver(VillagerRepository villagerRepository) {
        this.villagerRepository = villagerRepository;
    }

    public Iterable<Villager> findAllVillagers() {
        return villagerRepository.findAll();
    }

    public Villager findVillagerById(String id) {
        ObjectId oid = new ObjectId(id);
        return villagerRepository.findVillagerById(oid);
    }
}
