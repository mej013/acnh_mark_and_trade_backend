package acnh_backend.duomaoj.model;

import acnh_backend.duomaoj.type.Item;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "art")
public class Art implements Item {
    private ObjectId _id;
    private String uniqueId;
    private int internalId;
    private String[] source;
    private String category;
    private boolean genuine;
    private String name;
    private String title;
    private String artist;
    private String tag;
    private String imgUrl;
    private int buy;
    private int sell;
    private String description;

    @Override
    public String getId() {
        return _id.toString();
    }

}
