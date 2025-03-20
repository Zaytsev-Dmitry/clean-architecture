package com.clean.architecture.adapters.rest.security;

import com.clean.architecture.application.usecase.auth.AuthenticationUCase;
import com.clean.architecture.application.usecase.auth.CheckJWTSignatureUCase;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Component
public class JwtFilter extends OncePerRequestFilter {
    public static final String AUTHORIZATION = "Authorization";
    private final AuthenticationUCase authenticationUCase;
    private final CheckJWTSignatureUCase checkJWTSignatureUCase;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            final String authorization = request.getHeader(AUTHORIZATION);
            if (authorization != null) {
                final String token = authorization.replace("Bearer ", "");
                checkJWTSignatureUCase.checkSignature(token);
                UserDetails authenticate = authenticationUCase.authenticate(token);
                SecurityContextHolder.getContext().setAuthentication(
                        new UsernamePasswordAuthenticationToken(
                                authenticate,
                                null,
                                authenticate.getAuthorities()
                        )
                );
            }
        } catch (AccessDeniedException e) {
            // nothing
        } finally {
            filterChain.doFilter(request, response);
        }
    }
}
