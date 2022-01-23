package acnh_backend.duomaoj.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UpdatePasswordInput {
    private final String originalPassword;
    private final String newPassword;
}
