package com.dbd.commonlib;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    private String secret = "secret";

    private Long duration = 3600000L;

    public String generateToken() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", "dbd");
        return Jwts.builder()
                .setSubject("dbd")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + duration))
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public Claims decodeToken(String token) {
        try {
            return Jwts.parser().setSigningKey(secret)
                    .parseClaimsJws(token).getBody();
        } catch (UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException e) {
            return null;
        } catch (ExpiredJwtException e) {
            return null;
        }
    }
}
