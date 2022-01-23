package acnh_backend.duomaoj.security;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.time.Duration;

@ConstructorBinding
@ConfigurationProperties(prefix = "duomaoj.security")
@Getter
@RequiredArgsConstructor
public class SecurityProperties {
    private final int passwordStrength = 10;
    private final String tokenSecret = "mySecretKey";
    private final String tokenIssuer = "duomaoj";
    private final Duration tokenExpiration = Duration.ofHours(2);
}
