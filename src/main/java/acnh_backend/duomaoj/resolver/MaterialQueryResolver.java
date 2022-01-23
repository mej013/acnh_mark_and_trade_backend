package acnh_backend.duomaoj.resolver;

import acnh_backend.duomaoj.model.Material;
import acnh_backend.duomaoj.repository.ClothesRepository;
import acnh_backend.duomaoj.repository.MaterialRepository;
import acnh_backend.duomaoj.type.MaterialConnection;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaterialQueryResolver implements GraphQLQueryResolver {
    private MaterialRepository materialRepository;
    private ClothesRepository clothesRepository;

    public MaterialQueryResolver(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }


    public MaterialConnection findAllMaterial(int pageSize, String after) {
        pageSize = (pageSize == 0) ? 25 : pageSize;
        ObjectId oid = (after == null)? null : new ObjectId(after);
        MaterialConnection materialConnection = new MaterialConnection();
        Iterable<Material> allMaterial =  (oid == null) ? materialRepository.findAll()
                : materialRepository.findMaterialAfter(oid);
        List<Material> materials = (List<Material>) allMaterial;
        materials = materials.stream().sorted((m1, m2) -> m1.get_id().compareTo(m2.get_id())).limit(pageSize).collect(Collectors.toList());
        String cursor = materials.get(materials.size()-1).get_id().toString();
        boolean hasMore = ((List<Material>) allMaterial).stream().skip(pageSize).iterator().hasNext();
        materialConnection.setMaterials(materials);
        materialConnection.setCursor(cursor);
        materialConnection.setHasMore(hasMore);
        return materialConnection;
    }



    public Material findMaterialById(String id) {
        ObjectId oid = new ObjectId(id);
        return materialRepository.findMaterialById(oid);
    }
}
