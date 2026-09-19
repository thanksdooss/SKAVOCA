package com.skavoca.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtProvider {

    private static final Logger log = LoggerFactory.getLogger(JwtProvider.class);

    private static final String TYPE_CLAIM = "typ";
    private static final String TYPE_ACCESS = "access";
    private static final String TYPE_REFRESH = "refresh";

    private final SecretKey key;
    private final long accessExpiration;
    private final long refreshExpiration;

    public JwtProvider(
            @Value("${jwt.secret:}") String secret,
            @Value("${jwt.access-expiration}") long accessExpiration,
            @Value("${jwt.refresh-expiration}") long refreshExpiration) {
        if (secret == null || secret.isBlank()) {
            // 비밀키가 설정되지 않은 로컬 개발 환경: 실행할 때마다 임의의 키를 생성한다.
            // (서버를 재시작하면 기존 토큰은 무효화된다.) 운영 환경은 JWT_SECRET이 필수다.
            log.warn("JWT_SECRET is not set. Using a random key for this run (local development only).");
            this.key = Jwts.SIG.HS256.key().build();
        } else {
            byte[] bytes = secret.getBytes(StandardCharsets.UTF_8);
            if (bytes.length < 32) {
                throw new IllegalStateException("JWT_SECRET must be at least 256 bits (32 bytes).");
            }
            this.key = Keys.hmacShaKeyFor(bytes);
        }
        this.accessExpiration = accessExpiration;
        this.refreshExpiration = refreshExpiration;
    }

    public String generateAccessToken(Long userId, String email, String role) {
        return Jwts.builder()
                .claim(TYPE_CLAIM, TYPE_ACCESS)
                .claim("userId", userId)
                .claim("email", email)
                .claim("role", role)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + accessExpiration))
                .signWith(key)
                .compact();
    }

    public String generateRefreshToken(Long userId) {
        return Jwts.builder()
                .claim(TYPE_CLAIM, TYPE_REFRESH)
                .claim("userId", userId)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + refreshExpiration))
                .signWith(key)
                .compact();
    }

    /** API 인증용 Access Token인지 검증한다. Refresh Token으로는 API를 호출할 수 없다. */
    public boolean validateAccessToken(String token) {
        return hasType(token, TYPE_ACCESS);
    }

    /** 토큰 재발급용 Refresh Token인지 검증한다. Access Token으로는 재발급할 수 없다. */
    public boolean validateRefreshToken(String token) {
        return hasType(token, TYPE_REFRESH);
    }

    private boolean hasType(String token, String type) {
        try {
            Claims claims = parse(token);
            return type.equals(claims.get(TYPE_CLAIM, String.class));
        } catch (Exception e) {
            return false;
        }
    }

    private Claims parse(String token) {
        return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload();
    }

    public Long getUserIdFromToken(String token) {
        return parse(token).get("userId", Long.class);
    }

    public String getRoleFromToken(String token) {
        return parse(token).get("role", String.class);
    }

    public String getEmailFromToken(String token) {
        return parse(token).get("email", String.class);
    }
}
