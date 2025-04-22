package com.unicomer.test.application.user.service;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unicomer.test.domain.user.ProfileVO;
import com.unicomer.test.domain.user.User;
import com.unicomer.test.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public ProfileVO getProfile(User me, String targetUsername) {
        return this.getProfile(me, findUserByUsername(targetUsername));
    }

    @Transactional(readOnly = true)
    public ProfileVO getProfile(User me, User target) {
        return new ProfileVO(me, target);
    }

    private User findUserByUsername(String username) {
        String message = "User(`%s`) not found".formatted(username);
        return userRepository.findByUsername(username).orElseThrow(() -> new NoSuchElementException(message));
    }
}
