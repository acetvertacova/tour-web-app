package com.tour_web_app.Dto;

import com.tour_web_app.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationMapper {

    public User toEntity(RegistrationRequestDto registrationRequestDto) {
        return User.builder()
                .email(registrationRequestDto.email())
                .username(registrationRequestDto.username())
                .password(registrationRequestDto.password())
                .build();
    }

    public RegistrationResponseDto toRegistrationResponseDto(User user) {
        return new RegistrationResponseDto(user.getEmail(), user.getUsername());
    }

}
