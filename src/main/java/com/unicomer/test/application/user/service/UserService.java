package com.unicomer.test.application.user.service;

import com.unicomer.test.application.user.controller.LoginUserRequest;
import com.unicomer.test.application.user.controller.SignUpUserRequest;
import com.unicomer.test.application.user.controller.UpdateUserRequest;
import com.unicomer.test.domain.user.User;
import com.unicomer.test.domain.user.UserVO;

public interface UserService {
    User signUp(SignUpUserRequest request);

    UserVO login(LoginUserRequest request);

    UserVO update(User user, UpdateUserRequest request);
}
