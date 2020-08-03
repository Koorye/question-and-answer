package com.synx.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {
  public static final String ISSUER = "synx";
  public static final String SUBJECT = "question_and_answer";
  public static final String SIGN = "koorye_love_jwt";

  public static String getToken(int userId, int expireTime) {
    Date currentTime = new Date();

    JwtBuilder jwtBuilder = Jwts.builder()
        .setIssuer(ISSUER)
        .setSubject(SUBJECT)
        .setAudience(String.valueOf(userId))
        .setIssuedAt(currentTime)
        .setExpiration(new Date(System.currentTimeMillis() + expireTime * 1000))
        .signWith(SignatureAlgorithm.HS256, SIGN);

    return jwtBuilder.compact();
  }

  public static Claims parseToken(String token) {
    return Jwts.parser().setSigningKey(SIGN).parseClaimsJws(token).getBody();
  }
}
