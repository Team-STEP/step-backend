package com.teamstep.stepbackend.global.tool;

import com.teamstep.stepbackend.domain.auth.entity.Account;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtTool {
    @Value("${auth.jwt.secret-key}")
    private String SECRET_KEY;
    @Value("${auth.jwt.expiry-period")
    private Integer expiryPeriod;

    public String createToken(Account account) {
        return Jwts.builder()
                .claim("id", account.getId())
                .claim("owner_name", account.getOwnerName())
                .claim("authority", account.getAuthority())
                .setExpiration(new Date(System.currentTimeMillis() + expiryPeriod))
                .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8)), SignatureAlgorithm.HS256)
                .compact();
    }
}
