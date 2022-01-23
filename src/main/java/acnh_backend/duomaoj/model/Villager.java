package acnh_backend.duomaoj.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Setter
@Getter
@Document(collection = "villagers")
public class Villager {
    private ObjectId _id;
    private String name;
    private String photoImage;
    private String houseImage;
    private String species;
    private String gender;
    private String personality;
    private String hobby;
    private String birthday;
    private String catchphrase;
    private String favoriteSong;
    private String favoriteSaying;
    private List<String> furnitureList;
    private String uniqueEntryId;
    private String imgUrl;
}
