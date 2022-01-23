package acnh_backend.duomaoj.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "music")
public class Music {
    private ObjectId _id;
    private String name;
    private int buy;
    private int sell;
    private List<String> source;
    private String sourceNotes;
    private String catalog;
    private int internalId;
    private String uniqueEntryId;
    private String sheetKey;
    private String imgUrl;
}
