package com.tour_web_app.service;

import com.tour_web_app.entity.UserEntity;
import com.tour_web_app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.GONE;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserEntity getUserByUsername(final String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(GONE, "The user account has been deleted or inactivated"));
    }
}
