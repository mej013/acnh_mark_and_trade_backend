package acnh_backend.duomaoj.model;

import acnh_backend.duomaoj.type.Info;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "reactions")
public class Reaction {
    private ObjectId _id;
    private String name;
    private List<String> source;
    private String sourceNotes;
    private int internalId;
    private String uniqueEntryId;
    private String sheetKey;
    private String imgUrl;
}
