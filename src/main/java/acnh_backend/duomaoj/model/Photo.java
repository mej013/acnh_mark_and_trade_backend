package acnh_backend.duomaoj.model;

import acnh_backend.duomaoj.type.Info;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "photos")
public class Photo {
    private ObjectId _id;
    private String name;
    private boolean diy;
    private boolean customize;
    private int buy;
    private int sell;
    private List<String> source;
    private String catalog;
    private int internalId;
    private String sheetKey;
    private String imgUrl;
    private List<Info> variants;
    private int variants_len;

}
