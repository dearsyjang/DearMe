package com.dearme.demo.global.util.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    private final String KEY = "KEY";
    private final Long ACCESS_TOKEN_EXPIRED_TIME = 1000L * 60;
    private final Long REFREST_TOKEN_EXPIRED_TIME = 1000L * 60 * 24 * 14;

    public String getAccessToken(String id){
        Date now = new Date();
        return Jwts.builder().setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .claim("id", id)
                .setIssuer("dearme")
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + ACCESS_TOKEN_EXPIRED_TIME))
                .signWith(SignatureAlgorithm.HS256, KEY.getBytes())
                .compact();
    }

    public String getRefreshToken(){
        Date now = new Date();
        return Jwts.builder().setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setIssuer("dearme")
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + REFREST_TOKEN_EXPIRED_TIME))
                .signWith(SignatureAlgorithm.HS256, KEY.getBytes())
                .compact();
    }

    public Claims parseToken(String token){
        return Jwts.parser().setSigningKey(KEY).
                parseClaimsJwt(token).getBody();
    }
}
