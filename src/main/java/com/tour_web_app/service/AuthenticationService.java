package com.tour_web_app.service;

import com.tour_web_app.dto.AuthenticationRequestDto;
import com.tour_web_app.dto.AuthenticationResponseDto;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthenticationResponseDto authenticate(final AuthenticationRequestDto request) {
        try {//object contains the input info(username, password) for auth
            UsernamePasswordAuthenticationToken authToken = UsernamePasswordAuthenticationToken
                    .unauthenticated(request.username(), request.password());

            //checks if input === data from db
            Authentication authentication = authenticationManager.authenticate(authToken);

            //if success returns token
            String token = jwtService.generateToken(authentication);
            return new AuthenticationResponseDto(token);
        } catch (AuthenticationException e) {
            throw new ValidationException("Invalid username or password");
        }
    }
}