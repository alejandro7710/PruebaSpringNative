package com.unicomer.test.application.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.unicomer.test.application.config.BearerTokenSupplier;
import com.unicomer.test.application.user.service.ObservedUserService;
import com.unicomer.test.application.user.service.UserApplicationService;
import com.unicomer.test.application.user.service.UserService;
import com.unicomer.test.domain.user.UserRepository;

import io.micrometer.observation.ObservationRegistry;

@Configuration
public class UserServiceConfiguration {

    @Bean
    public UserService userService(
            UserApplicationService userApplicationService, ObservationRegistry observationRegistry) {
        return new ObservedUserService(userApplicationService, observationRegistry);
    }

    @Bean
    public UserApplicationService userApplicationService(
            UserRepository userRepository, PasswordEncoder passwordEncoder, BearerTokenSupplier bearerTokenSupplier) {
        return new UserApplicationService(userRepository, passwordEncoder, bearerTokenSupplier);
    }
}
