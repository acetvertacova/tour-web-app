package com.tour_web_app.controller;

import com.tour_web_app.Dto.AuthenticationRequestDto;
import com.tour_web_app.Dto.AuthenticationResponseDto;
import com.tour_web_app.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseDto> authenticate(@RequestBody final AuthenticationRequestDto authenticationRequestDto) {
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequestDto));
    }
}