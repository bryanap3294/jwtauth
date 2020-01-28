package com.bryan.promopack.jwtToken.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import static java.util.Collections.emptyList;

class TokenAuthenticationService {

  private static final Logger LOGGER = LoggerFactory.getLogger(TokenAuthenticationService.class);

  static final long EXPIRATIONTIME = 1800000; // 30 minutos
  static final String SECRET = "ThisIsASecret";
  static final String TOKEN_PREFIX = "Bearer";
  static final String HEADER_STRING = "Authorization";

  static void addAuthentication(HttpServletResponse res, Authentication authentication) {

    String JWT = Jwts.builder()
            .setSubject((String)authentication.getPrincipal())
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
            .signWith(SignatureAlgorithm.HS512, SECRET)
            .compact();
    res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);

  }

  static Authentication getAuthentication(HttpServletRequest request) {
    String token = request.getHeader(HEADER_STRING);
    Authentication authentication = null;
    if (token != null) {
      String user = Jwts.parser()
              .setSigningKey(SECRET)
              .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
              .getBody()
              .getSubject();
      return user != null ?
              new UsernamePasswordAuthenticationToken(user, null, emptyList()) :
              null;

    }
    return null;
  }
}