package acnh_backend.duomaoj.resolver;

import acnh_backend.duomaoj.model.Recipe;
import acnh_backend.duomaoj.repository.RecipeRepository;
import acnh_backend.duomaoj.type.RecipeConnection;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeQueryResolver implements GraphQLQueryResolver {
    private RecipeRepository recipeRepository;

    public RecipeQueryResolver(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public RecipeConnection findAllRecipes(int pageSize, String after) {
        pageSize = (pageSize == 0) ? 25: pageSize;
        ObjectId oid = (after == null)? null : new ObjectId(after);
        RecipeConnection recipeConnection = new RecipeConnection();
        Iterable<Recipe> allRecipes =  (oid == null) ? recipeRepository.findAll()
                : recipeRepository.findRecipeAfter(oid);
        List<Recipe> recipes = (List<Recipe>) allRecipes;
        recipes= recipes.stream().sorted((r1, r2) -> r1.get_id().compareTo(r2.get_id())).limit(pageSize).collect(Collectors.toList());
        String cursor = recipes.get(recipes.size()-1).get_id().toString();
        boolean hasMore = ((List<Recipe>) allRecipes).stream().skip(pageSize).iterator().hasNext();
        recipeConnection.setRecipes(recipes);
        recipeConnection.setCursor(cursor);
        recipeConnection.setHasMore(hasMore);
        return recipeConnection;
    }

    public Recipe findRecipeById(String id) {
        ObjectId oid = new ObjectId(id);
        return recipeRepository.findRecipeById(oid);
    }

    public Recipe findRecipeByItem(int itemId) {
        return recipeRepository.findRecipeByItem(itemId);
    }

    public Iterable<Recipe> findRecipeByIds(int[] ids) {
        System.out.println("run??????");
        return recipeRepository.findAllByInternalId(ids);
    }
}
