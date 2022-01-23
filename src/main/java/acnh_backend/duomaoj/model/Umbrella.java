package acnh_backend.duomaoj.model;

import acnh_backend.duomaoj.type.Item;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "umbrellas")
public class Umbrella implements Item {
    private ObjectId _id;
    private String name;
    private boolean diy;
    private int buy;
    private int sell;
    private String[] source;
    private String sourceNotes;
    private String seasonEvent;
    private String catalog;
    private int internalId;
    private String uniqueId;
    private String imgUrl;
    private String category;

    @Override
    public String getId() {
        return _id.toString();
    }
}
