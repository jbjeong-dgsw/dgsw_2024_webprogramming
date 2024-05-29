package kr.hs.dgsw.simple.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;



import java.security.Key;
import java.security.Principal;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

//@Component
@RequiredArgsConstructor
@Slf4j

public class JwtTokenProvider1 implements InitializingBean {

    private Key key;

    private static final String SECRET = "kkoqlgmoollahkk31#$afaga1243agdas$#1agsadgasgsgag";

    private static final long EXPIRY = 30 * 60 * 1000;

    private static final String AUTHORITIES_KEY = "Authorization";


    @Override
    public void afterPropertiesSet() throws Exception {
        byte[] keyBytes = Base64.getEncoder().encode(SECRET.getBytes());
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    public String createTokens(Authentication authentication) {
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        long now = (new Date()).getTime();
        Date validity = new Date(now + EXPIRY);

        return Jwts.builder()
                .setSubject(authentication.getName())
                .claim(AUTHORITIES_KEY, authorities)
                .signWith(key, SignatureAlgorithm.HS512)
                .setExpiration(validity)
                .compact();
    }

    public Authentication getAuthentication(String token) {
        Claims claims = null;

        try {
            claims = Jwts
                    .parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        log.info("[claims] {} - {}", claims.getSubject(), token);
        final String id = claims.getSubject();

        Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .toList();

        Principal principal = new Principal() {
            @Override
            public String getName() {
                return id;
            }
        };



        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }
}
