package com.unicomer.test.feriado;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unicomer.test.IntegrationTest;
import com.unicomer.test.application.user.controller.LoginUserRequest;
import com.unicomer.test.application.user.controller.SignUpUserRequest;
import com.unicomer.test.application.user.service.UserApplicationService;
import com.unicomer.test.domain.feriado.CreateFeriadoRequest;
import com.unicomer.test.domain.feriado.Feriado;
import com.unicomer.test.domain.feriado.FeriadoRepository;
import com.unicomer.test.domain.user.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@IntegrationTest
@DisplayName("Test Feriado API")
class FeriadoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserApplicationService userService;

    @Autowired
    private FeriadoRepository feriadoRepository;

    private String juanToken;
    private String pabloToken;

    @BeforeEach
    void setUp() throws Exception {
        SignUpUserRequest juanSignUpRequest = new SignUpUserRequest("juan@example.com", "juan", "password");
        User juan = userService.signUp(juanSignUpRequest);

        SignUpUserRequest simpsonSignUpRequest = new SignUpUserRequest("pablo@example.com", "pablo", "password");
        User pablo = userService.signUp(simpsonSignUpRequest);

        Feriado effectiveJava = Feriado.builder()
                .title("Domingo de Ramos")
                .type("festivo")
                .inalienable(1)
                .extra("Festivo")
                .build();
        feriadoRepository.save(effectiveJava);

        LoginUserRequest jamesLoginRequest = new LoginUserRequest("juan@example.com", "password");
        juanToken = "Token " + userService.login(jamesLoginRequest).token();

        LoginUserRequest simpsonLoginRequest = new LoginUserRequest("pablo@example.com", "password");
        pabloToken = "Token " + userService.login(simpsonLoginRequest).token();
    }

   

    @Test
    @DisplayName("Proporciona una API que permite a los usuarios no autenticados ver dias feriados.")
    void getFeriados() throws Exception {
        mockMvc.perform(get("/api/feriados"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.feriados[0].id").value(1))
                .andExpect(jsonPath("$.feriados[0].title").value("Viernes santo"))
                .andExpect(jsonPath("$.feriados[0].type").value("Religioso"))
                .andExpect(jsonPath("$.feriados[0].inalienable").value(1))
                .andExpect(jsonPath("$.feriados[0].extra").value("Religioso"))
                .andDo(print());
    }

    @Test
    @DisplayName("Proporciona una API que permite a los usuarios autenticados crear feriados.")
    void createFeriado() throws Exception {
        // given
    	 CreateFeriadoRequest request =
                 new CreateFeriadoRequest("Sabado de gloria", "Religioso", 1, "Religioso");

        // when
        ResultActions resultActions = mockMvc.perform(post("/api/feriados")
                .header("Authorization", juanToken)
                .content(objectMapper.writeValueAsString(Map.of("feriado", request)))
                .contentType(MediaType.APPLICATION_JSON));

        // then
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.feriados[0].id").value(1))
                .andExpect(jsonPath("$.feriados[0].title").value("Viernes santo"))
                .andExpect(jsonPath("$.feriados[0].type").value("Religioso"))
                .andExpect(jsonPath("$.feriados[0].inalienable").value(1))
                .andExpect(jsonPath("$.feriados[0].extra").value("Religioso"))
                .andDo(print());
    }
}
