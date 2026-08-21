package com.devPortes.configuration.security;

import com.devPortes.users.application.ports.input.IFindUserByEmail;
import com.devPortes.users.domain.exceptions.UserNotFoundException;
import com.devPortes.users.domain.model.UserModel;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class MySecurityFilter extends OncePerRequestFilter {
    private final TokenService tokenService;
    private final IFindUserByEmail iFindUserByEmail;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = recoverToken(request);

            if (token != null) {
                String subject = tokenService.getSubject(token);
                UserModel user = iFindUserByEmail.execute(subject)
                        .orElseThrow(() -> new UserNotFoundException(subject));

                CustomUserDetails customUserDetails = new CustomUserDetails(user);

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        customUserDetails, null, customUserDetails.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            filterChain.doFilter(request, response);
        }catch (Exception e){
            e.printStackTrace(); throw e;
        }
    }

    public String recoverToken(HttpServletRequest request){
        String authorizationHeader = request.getHeader("Authorization");
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
            return authorizationHeader.substring(7).trim();
        }
        return null;
    }

}
