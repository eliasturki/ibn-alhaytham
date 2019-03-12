/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.IbnalHaytham.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author abbasturki.elias
 */
public class JWTauthorizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Headers", "Origin,Accept,X-Requested-With,Content-Type,Access-Control-Request-Method,"
                + "Access-Control-Request-Headers,authorization");
        response.addHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin,Access-Control-Allow-Credentials,authorization");
        response.addHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,PATCH");
        if (request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
        } //        else if(request.getRequestURL().equals("/login")){
        //            chain.doFilter(request, response);
        //            return;
        //        }
        else {
            String jwtToken = request.getHeader(SecurityParams.JWT_HEADER);
            //System.out.println(jwtToken);
            if (jwtToken == null || !jwtToken.startsWith(SecurityParams.TOKEN_PREFIX)) {
                chain.doFilter(request, response);
                return;
            }

            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SecurityParams.PRIVATE_SECRET)).build();
//            DecodedJWT decodedJWT = JWT.decode(jwtToken.substring(SecurityParams.TOKEN_PREFIX.length()));
            DecodedJWT decodedJWT = verifier.verify(jwtToken.substring(SecurityParams.TOKEN_PREFIX.length()));
            String username = decodedJWT.getSubject();
            List<String> roles = decodedJWT.getClaims().get("roles").asList(String.class);
            System.out.println("roles = " + roles);
            Collection<GrantedAuthority> authoritys = new ArrayList<GrantedAuthority>();
            for (String r : roles) {
                authoritys.add(new SimpleGrantedAuthority(r));
            }
            UsernamePasswordAuthenticationToken token
                    = new UsernamePasswordAuthenticationToken(username, null, authoritys);
            SecurityContextHolder.getContext().setAuthentication(token);
            chain.doFilter(request, response);

        }
    }

}
