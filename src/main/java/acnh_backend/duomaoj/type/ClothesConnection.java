package acnh_backend.duomaoj.type;

import acnh_backend.duomaoj.model.Clothes;

import java.util.List;

public class ClothesConnection {
    private String cursor;
    private  boolean hasMore;
    private List<Clothes> allClothes;

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public void setAllClothes(List<Clothes> allClothes) {
        this.allClothes = allClothes;
    }
}
