package acnh_backend.duomaoj.type;


import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class UpdatePersonInput {
    private final String username;
    private final String island_title;
    private final String hemisphere;
}
