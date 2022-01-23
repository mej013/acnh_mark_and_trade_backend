package acnh_backend.duomaoj.resolver;

import acnh_backend.duomaoj.model.Food;
import acnh_backend.duomaoj.repository.FoodRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
public class FoodQueryResolver implements GraphQLQueryResolver {
    private FoodRepository foodRepository;

    public FoodQueryResolver(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public Iterable<Food> findAllFood() {
        return foodRepository.findAll();
    }

    public Food findFoodById(String id) {
        ObjectId oid = new ObjectId(id);
        return foodRepository.findFoodById(oid);
    }
}
