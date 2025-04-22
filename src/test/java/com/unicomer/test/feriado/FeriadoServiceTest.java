package com.unicomer.test.feriado;

import com.unicomer.test.IntegrationTest;
import com.unicomer.test.application.feriado.service.FeriadoService;
import com.unicomer.test.domain.feriado.CreateFeriadoRequest;
import com.unicomer.test.domain.feriado.Feriado;
import com.unicomer.test.domain.feriado.FeriadoFacets;
import com.unicomer.test.domain.feriado.FeriadoRepository;
import com.unicomer.test.domain.feriado.FeriadoVO;
import com.unicomer.test.domain.user.User;
import com.unicomer.test.domain.user.UserRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@IntegrationTest
@DisplayName("Servicio Feriado")
class FeriadoServiceTest {
    @Autowired
    private FeriadoService feriadoService;
    @Autowired
    private FeriadoRepository feriadoRepository;

    private Feriado effectiveJava;
    @Autowired
    private UserRepository userRepository;
    
    private User juan;
    private User pablo;
    @BeforeEach
    void setUp() throws Exception {
        juan = User.builder()
                .email("juan@example.com")
                .username("juan")
                .password("password")
                .build();
        userRepository.save(juan);

        pablo = User.builder()
                .email("pablo@example.com")
                .username("pablo")
                .password("password")
                .build();
        userRepository.save(pablo);

        

        effectiveJava = Feriado.builder()
                .title("Viernes santo")
                .type("Religioso")
                .inalienable(2)
                .extra("religioso2")
                .build();
        feriadoRepository.save(effectiveJava);
    }

  
    static Stream<Arguments> getFeriados() {
        return Stream.of(
                arguments(new FeriadoFacets("Domingo de ramos","religioso" , 0, 20), 1),
                arguments(new FeriadoFacets("Viernes Santo","religioso" , 0, 20), 1),
                arguments(new FeriadoFacets("Navidad","religioso" , 0, 20), 1),
                arguments(new FeriadoFacets("Dia del trabajo","festivo" , 0, 20), 1));
    }

//    @Test
//    @DisplayName("crear nuevos feriados.")
    void createFeriado() throws Exception {
        // given
        CreateFeriadoRequest request =
                new CreateFeriadoRequest("Domingo de Ramos", "Religioso", 1, "Religioso");

        // when
        FeriadoVO feriadoVO = feriadoService.createFeriado(juan, request);

        // then
        assertThat(request.title()).isEqualTo(feriadoVO.title());
        assertThat(request.type()).isEqualTo(feriadoVO.type());
        assertThat(request.extra()).isEqualTo(feriadoVO.extra());
    }

   
    
   
   

   

   

   


}
