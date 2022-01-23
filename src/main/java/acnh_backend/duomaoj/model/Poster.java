package acnh_backend.duomaoj.model;

import acnh_backend.duomaoj.type.Info;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "posters")
public class Poster {
    private ObjectId _id;
    private String name;
    private int buy;
    private int sell;
    private String catalog;
    private int internalId;
    private String uniqueEntryId;
    private String sheetKey;
    private String imgUrl;
}
