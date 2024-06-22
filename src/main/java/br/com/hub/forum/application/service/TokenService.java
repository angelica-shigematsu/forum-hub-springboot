package br.com.hub.forum.application.service;

import br.com.hub.forum.domain.models.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.create()
                    .withIssuer("API forumhub")
                    .withSubject(user.getEmail())
                    .withClaim("id", user.getId())
                    .withExpiresAt(dateExpires())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Token JWT inválido");
        }
    }

    public String getSubject(String tokenJWT) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("API forumhub")
                    .build()
                    .verify(tokenJWT).getSubject();

        } catch (JWTCreationException exception) {
            throw new RuntimeException("Token JWT inválido ou expeirado");
        }
    }

    private Instant dateExpires() {
        return LocalDateTime.now().plusHours(3).toInstant(ZoneOffset.of("-03:00"));
    }
}
