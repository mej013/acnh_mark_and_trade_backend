package acnh_backend.duomaoj.model;

import acnh_backend.duomaoj.type.Info;
import acnh_backend.duomaoj.type.Item;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "cooking")
public class Food implements Item {
    private ObjectId _id;
    private String name;
    private boolean diy;
    private int buy;
    private int sell;
    private List<String> source;
    private int foodPower;
    private String catalog;
    private int internalId;
    private String sheetKey;
    private boolean customize;
    private String imgUrl;
    private List<Info> variants;
    private int variants_len;
    private int recipeId;

    @Override
    public String getId() {
        return _id.toString();
    }
}
