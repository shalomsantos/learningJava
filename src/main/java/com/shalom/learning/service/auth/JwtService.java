package com.shalom.learning.service.auth;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.OctetSequenceKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

import org.springframework.stereotype.Service;

@Service
public class JwtService {
  @Value("${api.security.token.secret}")
  private String jwtSecret;

  @Bean
  JwtDecoder jwtDecoder() {
    SecretKey secretKey = new SecretKeySpec(jwtSecret.getBytes(), "HmacSHA256");
    return NimbusJwtDecoder.withSecretKey(secretKey).build();
  }

  @Bean
  JwtEncoder jwtEncoder() {
    JWK jwk = new OctetSequenceKey.Builder(jwtSecret.getBytes())
        .keyID("key-1")
        .algorithm(JWSAlgorithm.HS256)
        .build();

    JWKSource<SecurityContext> jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
    return new NimbusJwtEncoder(jwks);
  }

}
