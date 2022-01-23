package acnh_backend.duomaoj.model;

import acnh_backend.duomaoj.type.Item;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fossils")
public class Fossil implements Item {
    private ObjectId _id;
    private String uniqueId;
    private String category;
    private String name;
    private String imgUrl;
    private int internalId;
    private int sell;
    private String description;

    @Override
    public String getId() {
        return _id.toString();
    }
}
