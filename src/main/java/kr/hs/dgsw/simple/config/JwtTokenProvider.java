package kr.hs.dgsw.simple.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtTokenProvider implements InitializingBean {

    private static final String AUTHORITIES_KEY = "Authorization";

    private static final long EXPIRY = 30 * 60 * 1000;

    private static final String SECRET = "kasjglk12993@@5u#@q5fja!!@#gjaskgjlasglaien%%%jakga211235AGAGASD##afaff";

    private Key key;

    @Override
    public void afterPropertiesSet() throws Exception {
        byte[] keyBytes = Base64.getEncoder().encode(SECRET.getBytes());
        this.key =  Keys.hmacShaKeyFor(keyBytes);
    }

    public String createToken(Authentication authentication) {
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        Date expiry = new Date(System.currentTimeMillis() + EXPIRY);

        return Jwts.builder()
                .setSubject(authentication.getName())
                .claim(AUTHORITIES_KEY, authorities)
                .signWith(key)
                .setExpiration(expiry)
                .compact();
    }

}
