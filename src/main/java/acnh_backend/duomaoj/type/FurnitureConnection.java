package acnh_backend.duomaoj.type;

import acnh_backend.duomaoj.model.Furniture;

import java.util.List;

public class FurnitureConnection {
    private List<Furniture> allFurniture;
    private String cursor;
    private boolean hasMore;

    public List<Furniture> getAllFurniture() {
        return allFurniture;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public String getCursor() {
        return cursor;
    }

    public void setAllFurniture(List<Furniture> allFurniture) {
        this.allFurniture = allFurniture;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }
}
