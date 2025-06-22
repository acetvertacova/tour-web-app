package com.tour_web_app.service;

import com.tour_web_app.Dto.AuthenticationRequestDto;
import com.tour_web_app.Dto.AuthenticationResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthenticationResponseDto authenticate(final AuthenticationRequestDto request) {

        UsernamePasswordAuthenticationToken authToken = UsernamePasswordAuthenticationToken
                .unauthenticated(request.username(), request.password());

        Authentication authentication = authenticationManager.authenticate(authToken);

        String token = jwtService.generateToken(request.username());
        return new AuthenticationResponseDto(token);
    }
}