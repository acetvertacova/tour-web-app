package com.tour_web_app.controller;

import com.tour_web_app.dto.RegistrationRequestDto;
import com.tour_web_app.dto.RegistrationResponseDto;
import com.tour_web_app.dto.UserRegistrationMapper;
import com.tour_web_app.entity.UserEntity;
import com.tour_web_app.service.UserRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
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
