package usersmanagement.serviceImpl;

import java.util.Date;
import java.util.function.Function;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	private static final long expirationTime = 1800000;
	private String key = "HOYqeBksRl";

	public String generateToken(Authentication authentication) {

		return Jwts.builder().setIssuer("MinhaAplicacao")
                             .setSubject(authentication.getName())
                             .setIssuedAt(new Date())
				             .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                             .signWith(SignatureAlgorithm.HS256, key).compact();
	}
	
	
	public boolean isTokenValid(String token) {
		try {
			Jwts.parser().setSigningKey(key).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Integer getTokenId(String token) {
		Claims body = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
		return Integer.valueOf(body.getSubject());
	}
	
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
