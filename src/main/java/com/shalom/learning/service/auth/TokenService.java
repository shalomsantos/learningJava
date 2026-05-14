package com.shalom.learning.service.auth;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;

@Service
public class TokenService {

    @Autowired
    private JwtEncoder encoder;

    public String gerarToken(Authentication authentication) {
        Instant now = Instant.now();
        
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("http://localhost:9000")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(3600))
                .subject(authentication.getName())
                .build();
        var parameters = JwtEncoderParameters.from(JwsHeader.with(MacAlgorithm.HS256).build(), claims);
        
        return encoder.encode(parameters).getTokenValue();
    }
}