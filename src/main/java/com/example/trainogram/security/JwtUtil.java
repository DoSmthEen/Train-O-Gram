package com.example.trainogram.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.trainogram.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class JwtUtil {
    public final UserService userService;
    public String getUsername(String userToken) throws UsernameNotFoundException {

//        String jwt = userToken.substring("Bearer ".length());
        String username = JWT.decode(userToken.substring("Bearer ".length())).getSubject();
//        Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
//        JWTVerifier verifier = JWT.require(algorithm).build();
//        DecodedJWT decodedJWT = verifier.verify(jwt);
//
//        String username = decodedJWT.getSubject();
        if (userService.getUserByUsername(username) == null){
            throw new UsernameNotFoundException(username);
        }
        return username;
    }
}
