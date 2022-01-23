package acnh_backend.duomaoj.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.parameters.P;

import java.util.Set;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "users")
public class User {
    @Id
    @EqualsAndHashCode.Include
    private ObjectId personId;
    @EqualsAndHashCode.Include
    private String email;
    @Setter
    @EqualsAndHashCode.Include
    private String pwd;
    private Set<String> roles;
    @DBRef
    private Person person;


    public User withRole(String role) {
        if (this.roles == null) {
            this.roles = Set.of(role);
        } else {
            this.roles.add(role);
        }
        return this;
    }

    public User withoutRole(String role) {
        if (this.roles != null) {
            this.roles.remove(role);
        }
        return this;
    }
}
