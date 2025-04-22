package com.unicomer.test.application.user.controller;

import org.springframework.web.bind.annotation.*;

import com.unicomer.test.application.user.service.ProfileService;
import com.unicomer.test.domain.user.ProfileVO;
import com.unicomer.test.domain.user.User;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;

    @GetMapping("/api/profiles/{username}")
    public ProfileResponse getProfile(User me, @PathVariable("username") String target) {
        ProfileVO profile = profileService.getProfile(me, target);
        return new ProfileResponse(profile);
    }


}
