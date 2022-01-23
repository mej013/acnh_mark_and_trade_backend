package acnh_backend.duomaoj.resolver;

import acnh_backend.duomaoj.model.Furniture;
import acnh_backend.duomaoj.repository.FurnitureRepository;
import acnh_backend.duomaoj.type.FurnitureConnection;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FurnitureQueryResolver implements GraphQLQueryResolver {
    private FurnitureRepository furnitureRepository;

    public FurnitureQueryResolver(FurnitureRepository furnitureRepository) {
        this.furnitureRepository = furnitureRepository;
    }

    public FurnitureConnection findAllFurniture(int pageSize, String after) {
        pageSize = (pageSize == 0) ? 25: pageSize;
        ObjectId oid = (after == null)? null : new ObjectId(after);
        FurnitureConnection furnitureConnection = new FurnitureConnection();
        Iterable<Furniture> allFurniture =  (oid == null) ? furnitureRepository.findAll()
                        : furnitureRepository.findFurnitureAfter(oid);
        List<Furniture> furniture = (List<Furniture>) allFurniture;
        furniture = furniture.stream().sorted((f1, f2) -> f1.get_id().compareTo(f2.get_id())).limit(pageSize).collect(Collectors.toList());
        String cursor = furniture.get(furniture.size()-1).get_id().toString();
        boolean hasMore = ((List<Furniture>) allFurniture).stream().skip(pageSize).iterator().hasNext();
        furnitureConnection.setAllFurniture(furniture);
        furnitureConnection.setCursor(cursor);
        furnitureConnection.setHasMore(hasMore);
        return furnitureConnection;
    }

    public Furniture findFurnitureById(String id) {
        ObjectId oid = new ObjectId(id);
        return furnitureRepository.findFurnitureById(oid);
    }
}
