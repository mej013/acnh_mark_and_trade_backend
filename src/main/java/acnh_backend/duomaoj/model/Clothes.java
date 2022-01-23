package acnh_backend.duomaoj.model;

import acnh_backend.duomaoj.type.Info;
import acnh_backend.duomaoj.type.Item;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "clothes")
public class Clothes implements Item {
    private ObjectId _id;
    private String name;
    private boolean diy;
    private int buy;
    private int sell;
    private String[] source;
    private String sourceNotes;
    private String seasonalAvailability;
    private boolean villagerEquippable;
    private String catalog;
    private int internalId;
    private String category;
    private String imgUrl;
    private int recipeId;
    private String[] styles;
    private List<Info> variants;
    private int variants_len;

    public ObjectId get_id() {return _id;}


    @Override
    public String getId() {
        return _id.toString();
    }
}
