package acnh_backend.duomaoj.security.exception;

import lombok.RequiredArgsConstructor;

import java.text.MessageFormat;

@RequiredArgsConstructor
public class PersonNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 4624121128954970095L;
    private final String id;

    @Override
    public String getMessage() {
        return MessageFormat.format("Person with ID ''{0}'' isn''t available", id);
    }
}
