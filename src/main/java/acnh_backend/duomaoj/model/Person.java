package acnh_backend.duomaoj.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "persons")
public class Person {
    @Id
    @EqualsAndHashCode.Include
    private ObjectId _id;
    @Setter
    @EqualsAndHashCode.Include
    private String username;
    @Setter
    @EqualsAndHashCode.Include
    private String island_title;
    @Setter
    private String hemisphere;
    @Setter
    private String email;
    @Setter
    private List<String> roles;
    @Setter
    private List<Integer> markedItems;
    @EqualsAndHashCode.Include
    @DBRef
    private User user;
}
