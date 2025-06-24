package com.tour_web_app.Dto;

import com.tour_web_app.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationMapper {

    public UserEntity toEntity(RegistrationRequestDto registrationRequestDto) {
        return UserEntity.builder()
                .email(registrationRequestDto.email())
                .username(registrationRequestDto.username())
                .password(registrationRequestDto.password())
                .build();
    }

    public RegistrationResponseDto toRegistrationResponseDto(UserEntity user) {
        return new RegistrationResponseDto(user.getEmail(), user.getUsername());
    }

}
