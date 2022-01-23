package acnh_backend.duomaoj.resolver;

import acnh_backend.duomaoj.repository.ClothesRepository;
import acnh_backend.duomaoj.repository.FurnitureRepository;
import acnh_backend.duomaoj.repository.MaterialRepository;
import acnh_backend.duomaoj.repository.ToolRepository;
import acnh_backend.duomaoj.type.Item;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemResolver implements GraphQLQueryResolver {
    private final ClothesRepository clothesRepository;
    private final MaterialRepository materialRepository;
    private final ToolRepository toolRepository;
    private final FurnitureRepository furnitureRepository;

    public ItemResolver(ClothesRepository clothesRepository, MaterialRepository materialRepository, ToolRepository toolRepository,
                        FurnitureRepository furnitureRepository) {
        this.clothesRepository = clothesRepository;
        this.materialRepository = materialRepository;
        this.toolRepository = toolRepository;
        this.furnitureRepository = furnitureRepository;
    }

    public Item getMaterialItemBymId(String category, int mid) {
        if (category.equals("clothes")) {
            return clothesRepository.findClothesByInternalId(mid);
        }
        else if (category.equals("material")) {
            return materialRepository.findMaterialByInternalId(mid);
        }
        else if (category.equals("tools")) {
            return toolRepository.findToolByInternalId(mid);
        }
        else if (category.equals("furnitures")) {
            return furnitureRepository.findFurnitureByInternalId(mid);
        }
        return null;
    }

    public List<Item> findMaterialInfoBymIds(String[] categories, int[] mIds) {
        List<Item> result = new ArrayList<Item>();
        for (int i = 0; i < categories.length; i++) {
            result.add(getMaterialItemBymId(categories[i], mIds[i]));
        }
        return result;
    }


}
