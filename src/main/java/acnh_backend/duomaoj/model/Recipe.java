package acnh_backend.duomaoj.model;

import acnh_backend.duomaoj.type.Item;
import acnh_backend.duomaoj.type.MaterialInfo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "recipes")
public class Recipe implements Item {
    private ObjectId _id;
    private String name;
    private String imgUrl;
    private int buy;
    private int sell;
    private String[] source;
    private String sourceNotes;
    private int recipesToUnlock;
    private int internalId;
    private String tag;
    private String category;
    private List<MaterialInfo> materials;
    private int craftedId;

    public ObjectId get_id() {return _id;}

    @Override
    public String getId() {
        return _id.toString();
    }
}
