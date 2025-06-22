package com.tour_web_app.Dto;

import com.tour_web_app.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserProfileDto toUserProfileDto(UserEntity user) {
        return new UserProfileDto(user.getEmail(), user.getUsername());
    }
}
