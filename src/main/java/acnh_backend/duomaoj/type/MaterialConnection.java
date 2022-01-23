package acnh_backend.duomaoj.type;

import acnh_backend.duomaoj.model.Material;

import java.util.List;

public class MaterialConnection {
    String cursor;
    boolean hasMore;
    List<Material> materials;

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }
}
