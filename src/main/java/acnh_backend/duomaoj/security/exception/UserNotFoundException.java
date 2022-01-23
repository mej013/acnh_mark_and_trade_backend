package acnh_backend.duomaoj.security.exception;

import lombok.RequiredArgsConstructor;

import java.text.MessageFormat;

@RequiredArgsConstructor
public class UserNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -4197339452705364933L;
    private final String id;

    @Override
    public String getMessage() {
        return MessageFormat.format("User with ID ''{0}'' isn''t available", id);
    }
}