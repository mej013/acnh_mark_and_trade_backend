package acnh_backend.duomaoj.resolver;

import acnh_backend.duomaoj.model.Clothes;
import acnh_backend.duomaoj.repository.ClothesRepository;
import acnh_backend.duomaoj.type.ClothesConnection;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClothesQueryResolver implements GraphQLQueryResolver {
    private ClothesRepository clothesRepository;

    public ClothesQueryResolver(ClothesRepository clothesRepository) {
        this.clothesRepository = clothesRepository;
    }

    public ClothesConnection findAllClothes(int pageSize, String after) {
        pageSize = (pageSize == 0) ? 25: pageSize;
        ObjectId oid = (after == null) ? null : new ObjectId(after);
        ClothesConnection clothesConnection = new ClothesConnection();
        Iterable<Clothes> allClothes = (oid == null) ? clothesRepository.findAll()
                : clothesRepository.findClothesAfter(oid);
        List<Clothes> clothes = (List<Clothes>) allClothes;
        clothes = clothes.stream().sorted((c1,c2) -> c1.get_id().compareTo(c2.get_id())).limit(pageSize).collect(Collectors.toList());
        String cursor = clothes.get(clothes.size()-1).get_id().toString();
        boolean hasMore = ((List<Clothes>) allClothes).stream().skip(pageSize).iterator().hasNext();
        clothesConnection.setAllClothes(clothes);
        clothesConnection.setCursor(cursor);
        clothesConnection.setHasMore(hasMore);
        return clothesConnection;
    }

    public Clothes findClothesById(String id) {
        ObjectId oid = new ObjectId(id);
        return clothesRepository.findClothesById(oid);
    }

    public Iterable<Clothes> findClothesByCategory(String category) {
        return clothesRepository.findByCategory(category);
    }
}
