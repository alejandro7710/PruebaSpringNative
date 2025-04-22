package com.unicomer.test.application.user;

import com.unicomer.test.IntegrationTest;
import com.unicomer.test.application.user.controller.LoginUserRequest;
import com.unicomer.test.application.user.controller.SignUpUserRequest;
import com.unicomer.test.application.user.controller.UpdateUserRequest;
import com.unicomer.test.application.user.service.UserApplicationService;
import com.unicomer.test.domain.user.User;
import com.unicomer.test.domain.user.UserVO;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@IntegrationTest
@DisplayName("Test USuario Service")
class UserApplicationServiceTest {
    @Autowired
    private UserApplicationService sut;

    @Test
    @DisplayName("dar de alta a un usuario.")
    void signUp() throws Exception {
        // given
        // - sign up request
        SignUpUserRequest signUpRequest = new SignUpUserRequest("juans@example.com", "juans", "password");

        // when
        User user = sut.signUp(signUpRequest);

        // then
        assertThat(user.getId()).isNotNull();
        assertThat(user.getEmail()).isEqualTo("juans@example.com");
        assertThat(user.getUsername()).isEqualTo("juans");
        assertThat(user.getPassword()).isNotEqualTo("password");
    }

    @Test
    @DisplayName("provides login function.")
    void login() throws Exception {
        // given
        // - sign up
        SignUpUserRequest signUpRequest = new SignUpUserRequest("juans@example.com", "juans", "password");
        sut.signUp(signUpRequest);

        // when
        UserVO user = sut.login(new LoginUserRequest("juans@example.com", "password"));

        // then
        assertThat(user.email()).isEqualTo("juans@example.com");
        assertThat(user.username()).isEqualTo("juans");
        assertThat(user.token()).isNotEmpty();
        assertThat(user.bio()).isEmpty();
        assertThat(user.image()).isNull();
    }

    @Test
    @DisplayName("actualizar usuario.")
    void update() throws Exception {
        SignUpUserRequest signUpRequest = new SignUpUserRequest("juans@example.com", "juan", "password");
        User user = sut.signUp(signUpRequest);

        String email = "juan@example.com";
        String username = "juan";
        String password = "5678";
        String bio = "asd";
        String image = "https://example.com/j1.jpg";
        UpdateUserRequest updateRequest = new UpdateUserRequest(email, username, password, bio, image);

        UserVO userVO = sut.update(user, updateRequest);

        assertThat(userVO.email()).isEqualTo("juan@example.com");
        assertThat(userVO.username()).isEqualTo("juan");
        assertThat(userVO.bio()).isEqualTo("asd");
        assertThat(userVO.image()).isEqualTo("https://example.com/j1.jpg");
    }
}
