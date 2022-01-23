package acnh_backend.duomaoj.model;

import java.util.List;
import acnh_backend.duomaoj.type.Info;
import acnh_backend.duomaoj.type.Item;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "furnitures")

public class Furniture implements Item {
    private ObjectId _id;
    private String cursor;
    private String name;
    private String category;
    private String catalog;
    private int internalId;
    private String imgUrl;
    private int buy;
    private int sell;
    private boolean diy;
    private boolean customize;
    private String sourceNotes;
    private String seasonEvent;
    private String tag;
    private String series;
    private String[] source;
    private List<Info> variants;
    private int variants_len;
    private int recipeId;

    public ObjectId get_id() {return _id;}


    @Override
    public String getId() {
        return _id.toString();
    }
}
