package acnh_backend.duomaoj.type;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreatePersonInput {
    private final String username;
    private final String island_title;
    private final String hemisphere;
}
