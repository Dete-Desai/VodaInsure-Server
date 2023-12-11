package io.springboot.vodainsure.service;

// JWT service class
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwebtService {

// @Value("${bezkoder.app.jwtSecret}")
private String secret = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";;

// @Value("${bezkoder.app.jwtExpirationMs}")
// private int expiraytion;

// Generate a token for a given user
public String generateToken(UserDetails userDetails) {
Map<String, Object> claims = new HashMap<>();
claims.put("authorities", userDetails.getAuthorities());
return createToken(claims, userDetails.getUsername());
}

// Create a token with the given claims and subject
private String createToken(Map<String, Object> claims, String subject) {
return Jwts.builder()
.setClaims(claims)
.setSubject(subject)
.setIssuedAt(new Date(System.currentTimeMillis()))
.setExpiration(new Date(System.currentTimeMillis() + 1000*60*30))
.signWith(SignatureAlgorithm.HS256, secret).compact();
}

// Extract the username from a token
public String extractUsername(String token) {
return extractClaim(token, Claims::getSubject);
}

// Extract the expiration date from a token
public Date extractExpiration(String token) {
return extractClaim(token, Claims::getExpiration);
}

// Extract a claim from a token
public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
final Claims claims = extractAllClaims(token);
return claimsResolver.apply(claims);
}

// Extract all claims from a token
private Claims extractAllClaims(String token) {
return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
}

// Check if a token is expired
private Boolean isTokenExpired(String token) {
return extractExpiration(token).before(new Date());
}

// Validate a token with a given user
public Boolean validateToken(String token, UserDetails userDetails) {
final String username = extractUsername(token);
return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
}
}

