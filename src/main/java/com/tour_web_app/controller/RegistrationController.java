package com.tour_web_app.controller;

import com.tour_web_app.Dto.RegistrationRequestDto;
import com.tour_web_app.Dto.RegistrationResponseDto;
import com.tour_web_app.Dto.UserRegistrationMapper;
import com.tour_web_app.entity.UserEntity;
import com.tour_web_app.service.UserRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class RegistrationController {
    private final UserRegistrationService userRegistrationService;
    private final UserRegistrationMapper userRegistrationMapper;

    @PostMapping("/register")
    public ResponseEntity<RegistrationResponseDto> registerUser(@RequestBody RegistrationRequestDto registrationDto){
        UserEntity registeredUser = userRegistrationService.registerUser(userRegistrationMapper.toEntity(registrationDto));

        return ResponseEntity.ok(userRegistrationMapper.toRegistrationResponseDto(registeredUser));
}
}
