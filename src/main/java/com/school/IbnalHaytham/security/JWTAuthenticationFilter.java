/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.IbnalHaytham.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.school.IbnalHaytham.model.AppUser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 *
 * @author abbasturki.elias
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        super();
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        AppUser appUser=null;
        try {
            appUser= new ObjectMapper().readValue(request.getInputStream(), AppUser.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("****************");
        System.out.println("username : "+appUser.getUsername());
        System.out.println("pass : "+appUser.getMotdepasse());
        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(appUser.getUsername(), appUser.getMotdepasse()));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
       
        User springUser= (User) authResult.getPrincipal();
        
        List<String> roles= new ArrayList<>();
        springUser.getAuthorities().forEach(a->{
          roles.add(a.getAuthority());
        });
        
        String jwtToken=JWT.create()
                .withIssuer(request.getRequestURI())
                .withSubject(springUser.getUsername())
                .withArrayClaim("roles", roles.toArray(new String[roles.size()]))
                .withExpiresAt(new Date(System.currentTimeMillis()+10*24*3600))
                .sign(Algorithm.HMAC256(SecurityParams.PRIVATE_SECRET));
        
//        String jwtToken=Jwts.builder()
//                .setSubject(springUser.getUsername())
//                .setExpiration(new Date(System.currentTimeMillis()+SecurityParams.EXPIRATION_TIME))
//                .signWith(SignatureAlgorithm.HS256, SecurityParams.PRIVATE_SECRET)
//                .claim("roles", springUser.getAuthorities())
//                .compact();
        response.addHeader(SecurityParams.JWT_HEADER, SecurityParams.TOKEN_PREFIX+jwtToken);
    }
    
    
    
    

   

}
