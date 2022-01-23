package acnh_backend.duomaoj.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateUserInput {
    private final String email;
    private final String password;
}
