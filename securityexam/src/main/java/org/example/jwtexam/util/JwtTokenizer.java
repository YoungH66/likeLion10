package org.example.jwtexam.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class JwtTokenizer {
    private final byte[] accessSecret;
    private final byte[] refreshSecret;

    public static Long ACCESS_TOKEN_EXPIRATION_TIME = 1 * 60 * 1000L;  // 1min.
    public static Long REFRESH_TOKEN_EXPIRATION_TIME = 7 * 24 * 60 * 60 * 1000L; // 7d.

    public JwtTokenizer(@Value("${jwt.secretKey}") String accessSecret, @Value("${jwt.refreshKey}")String refreshSecret) {
        this.accessSecret = accessSecret.getBytes(StandardCharsets.UTF_8);  // byte 배열이니까 String으로 받아온걸 byte로 저장
        this.refreshSecret = refreshSecret.getBytes(StandardCharsets.UTF_8);
    }

    private String createToken(Long id, String email, String name, String username,
                               List<String> roles, Long expire, byte[] sKey){
        Claims claims = Jwts.claims().setSubject(email);

        // 필요한 정보들을 저장
        claims.put("username", username);
        claims.put("name", name);
        claims.put("userId", id);
        claims.put("roles", roles);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime()+expire))
                .signWith(getSigningKey(sKey))
                .compact();
    }

    public static Key getSigningKey(byte[] secretKey){
        return Keys.hmacShaKeyFor(secretKey);
    }

    //ACCESS TOKEN 생성
    public String createAccessToken(Long id, String email, String name, String username,
                                    List<String> roles){
        return createToken(id, email, name, username, roles, ACCESS_TOKEN_EXPIRATION_TIME, accessSecret);
    }
    //REFRESH TOKEN 생성
    public String createRefreshToken(Long id, String email, String name, String username, List<String> roles){
        return createToken(id, email, name, username, roles, REFRESH_TOKEN_EXPIRATION_TIME, refreshSecret);
    }

    public Long getUserIdFromToken(String token){
        String[] tokenArr = token.split(" ");
        token = tokenArr[1];
        Claims claims = parseToken(token,accessSecret);
        return Long.valueOf((Integer)claims.get("userId"));
    }

    public Claims parseToken(String token, byte[] secretKey){
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey(secretKey))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }


    public Claims parseAccessToken(String accessToken) {
        return parseToken(accessToken, accessSecret);
    }

    public Claims parseRefreshToken(String refreshToken) {
        return parseToken(refreshToken, refreshSecret);
    }
}
