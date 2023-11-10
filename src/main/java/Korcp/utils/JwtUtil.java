package Korcp.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {

    public static  String createJwt(String email, String secretkey, Long expiredMs){
        Claims claims = Jwts.claims();
        claims.put("email",email);

        return Jwts.builder()
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ expiredMs))
                .signWith(SignatureAlgorithm.HS512,secretkey)
                .compact();
    }
}
