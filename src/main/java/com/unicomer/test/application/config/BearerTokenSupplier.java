package com.unicomer.test.application.config;

import java.time.Instant;

import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Component;

import com.unicomer.test.domain.user.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class BearerTokenSupplier {
    private final JwtEncoder jwtEncoder;

    public String supply(User user) {
        Instant now = Instant.now();
        JwtClaimsSet claimsSet = JwtClaimsSet.builder()
                .issuer("https://realworld.io")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(300))
                .subject(user.getId().toString())
                .build();

        JwtEncoderParameters parameters = JwtEncoderParameters.from(claimsSet);
        String token = jwtEncoder.encode(parameters).getTokenValue();
        log.info("Generated bearer token with user id `{}`: {}", user.getId(), token);
        return token;
    }
}
