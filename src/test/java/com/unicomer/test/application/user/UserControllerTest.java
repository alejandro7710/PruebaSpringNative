package com.unicomer.test.application.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unicomer.test.IntegrationTest;
import com.unicomer.test.application.user.controller.LoginUserRequest;
import com.unicomer.test.application.user.controller.SignUpUserRequest;
import com.unicomer.test.application.user.controller.UpdateUserRequest;
import com.unicomer.test.application.user.service.UserApplicationService;
import com.unicomer.test.domain.user.UserVO;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@IntegrationTest
@DisplayName("The User APIs")
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserApplicationService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("dar de alta a usuario.")
    void signUp() throws Exception {
        SignUpUserRequest signUpRequest = new SignUpUserRequest("juan@example.com", "juan", "password");

        // cuendo
        ResultActions resultActions = mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(Map.of("user", signUpRequest))));

        // entonces
        resultActions
                .andExpect(status().isTemporaryRedirect())
                .andExpect(view().name("redirect:/api/users/login"))
                .andExpect(model().attributeExists("user"))
                .andExpect(model().attribute(
                                "user", Map.of("user", new LoginUserRequest("juan@example.com", "password"))))
                .andDo(print());
    }

    @Test
    @DisplayName("test login.")
    void login() throws Exception {
// dado
    	SignUpUserRequest signUpRequest = new SignUpUserRequest("juan@example.com", "juan", "password");
        userService.signUp(signUpRequest);

        // - login request
        LoginUserRequest loginRequest = new LoginUserRequest("juan@example.com", "password");

        // cuando
        ResultActions resultActions = mockMvc.perform(post("/api/users/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(Map.of("user", loginRequest))));

        // entonces
        resultActions
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user.email").value("juan@example.com"))
                .andExpect(jsonPath("$.user.username").value("juan"))
                .andExpect(jsonPath("$.user.token").isNotEmpty())
                .andExpect(jsonPath("$.user.bio").isEmpty())
                .andExpect(jsonPath("$.user.image").isEmpty())
                .andDo(print());
    }

    @Test
    @DisplayName("test obtener usurio actual.")
    void getCurrentUser() throws Exception {
       // dado
        SignUpUserRequest signUpRequest = new SignUpUserRequest("juan@example.com", "juan", "password");
        userService.signUp(signUpRequest);

        // - login - obtener - token
        LoginUserRequest loginRequest = new LoginUserRequest("juan@example.com", "password");
        String juanToken = userService.login(loginRequest).token();

        // cuando
        ResultActions resultActions = mockMvc.perform(get("/api/user").header("Authorization", "Token " + juanToken));

        // entonces
        resultActions
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user.email").value("juan@example.com"))
                .andExpect(jsonPath("$.user.username").value("juan"))
                .andExpect(jsonPath("$.user.token").isNotEmpty())
                .andExpect(jsonPath("$.user.bio").isEmpty())
                .andExpect(jsonPath("$.user.image").isEmpty())
                .andDo(print());
    }

    @Test
    @DisplayName("test actualizar usuario API.")
    void update() throws Exception {
        // given
        // - sign up
        SignUpUserRequest signUpRequest = new SignUpUserRequest("juan@example.com", "juan", "password");
        userService.signUp(signUpRequest);

        // - login and get authorization token
        LoginUserRequest loginRequest = new LoginUserRequest("juan@example.com", "password");
        UserVO userVO = userService.login(loginRequest);

        // - update request
        String email = "juan.to@example.com";
        String username = "juan.to";
        String password = "5678";
        String bio = "juan";
        String image = "https://example2.com/juan2.jpg";
        UpdateUserRequest updateRequest = new UpdateUserRequest(email, username, password, bio, image);

        // when
        ResultActions resultActions = mockMvc.perform(put("/api/user")
                .header("Authorization", "Token " + userVO.token())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(Map.of("user", updateRequest))));

        // then
        resultActions
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user.email").value("juan.to@example.com"))
                .andExpect(jsonPath("$.user.username").value("juan.to"))
                .andExpect(jsonPath("$.user.token").isNotEmpty())
                .andExpect(jsonPath("$.user.bio").value("juan"))
                .andExpect(jsonPath("$.user.image").value("https://example2.com/juan2.jpg"))
                .andDo(print());
    }
}
