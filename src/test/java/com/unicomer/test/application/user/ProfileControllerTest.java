package com.unicomer.test.application.user;

import com.unicomer.test.IntegrationTest;
import com.unicomer.test.application.user.controller.LoginUserRequest;
import com.unicomer.test.application.user.controller.SignUpUserRequest;
import com.unicomer.test.application.user.service.UserApplicationService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@IntegrationTest
@DisplayName("Perfil Api Test")
class ProfileControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserApplicationService userService;

    @BeforeEach
    void setUp() throws Exception {
        userService.signUp(new SignUpUserRequest("juan@example.com", "juan", "password"));
        userService.signUp(new SignUpUserRequest("pablo@example.com", "pablo", "password"));
    }

    @Test
    @DisplayName("provee un test para obtener el perfil usuario no autenticado.")
    void getProfileOnUnauthenticated() throws Exception {
        // when
        ResultActions resultActions = mockMvc.perform(get("/api/profiles/{username}", "pablo"));

        // then
        resultActions
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.profile.username").value("pablo"))
                .andExpect(jsonPath("$.profile.bio").isEmpty())
                .andExpect(jsonPath("$.profile.image").isEmpty())
                .andExpect(jsonPath("$.profile.following").value(false)) // siempre falso
                .andDo(print());
    }

    @Test
    @DisplayName(
            "provides an API that allows you to know whether you are following a user when viewing another user's profile in an authenticated state.")
    void getProfileOnAuthenticate() throws Exception {
        // given
        // - login and get authorization token
        LoginUserRequest loginRequest = new LoginUserRequest("juan@example.com", "password");
        String juanToken = userService.login(loginRequest).token();

        // when
        ResultActions resultActions = mockMvc.perform(
                get("/api/profiles/{username}", "pablo").header("Authorization", "Token " + juanToken));

        // then
        resultActions
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.profile.username").value("pablo"))
                .andExpect(jsonPath("$.profile.bio").isEmpty())
                .andExpect(jsonPath("$.profile.image").isEmpty())
                .andExpect(jsonPath("$.profile.following").value(false))
                .andDo(print());
    }

   

}
