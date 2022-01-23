package acnh_backend.duomaoj.type;

import acnh_backend.duomaoj.model.Recipe;
import org.bson.types.ObjectId;

import java.util.List;

public class RecipeConnection {
    private String cursor;
    private boolean hasMore;
    private List<Recipe> recipes;

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
}
