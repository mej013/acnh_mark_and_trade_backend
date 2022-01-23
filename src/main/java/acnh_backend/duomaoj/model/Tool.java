package acnh_backend.duomaoj.model;

import acnh_backend.duomaoj.type.Info;
import acnh_backend.duomaoj.type.Item;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "tools")
public class Tool implements Item {
    private ObjectId _id;
    private String name;
    private boolean customize;
    private boolean diy;
    private float uses;
    private int internalId;
    private String category;
    private String sourceNotes;
    private String[] source;
    private String seasonEvent;
    private int buy;
    private int sell;
    private String imgUrl;
    private List<Info> variants;
    private int variants_len;

    @Override
    public String getId() {
        return _id.toString();
    }
}

