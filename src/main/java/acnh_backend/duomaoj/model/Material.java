package acnh_backend.duomaoj.model;

import acnh_backend.duomaoj.type.Item;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "material")
public class Material implements Item {
    private ObjectId _id;
    private String name;
    private int buy;
    private int sell;
    private boolean diy;
    private int exchangePrice;
    private String exchangeCurrency;
    private String[] source;
    private String sourceNotes;
    private String seasonEvent;
    private boolean seasonEventExclusive;
    private String tag;
    private int internalId;
    private String category;
    private String uniqueId;
    private String imgUrl;
    private int recipeId;
    private int[] objIds;

    public ObjectId get_id() {return _id;}

    @Override
    public String getId() {
        return _id.toString();
    }
}
