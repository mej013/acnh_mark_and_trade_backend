package acnh_backend.duomaoj.model;

import acnh_backend.duomaoj.type.Item;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import acnh_backend.duomaoj.type.MonthArr;
import acnh_backend.duomaoj.type.HourArr;

@Document(collection = "creatures")
public class Creature implements Item {
    private ObjectId _id;
    private String uniqueId;
    private String category;
    private String name;
    private String imgUrl;
    private int sell;
    private String whereHow;
    private String shadow;
    private String speed;
    private String weather;
    private String catchDifficulty;
    private int catchUnlock;
    private int internalId;
    private int specialSell;
    private String description;
    private String catchPhrase;
    private MonthArr activeMonths;
    private HourArr activeHours;

    @Override
    public String getId() {
        return _id.toString();
    }
}
