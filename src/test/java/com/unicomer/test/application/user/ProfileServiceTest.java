package com.unicomer.test.application.user;

import com.unicomer.test.IntegrationTest;
import com.unicomer.test.application.user.service.ProfileService;
import com.unicomer.test.domain.user.ProfileVO;
import com.unicomer.test.domain.user.User;
import com.unicomer.test.domain.user.UserRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@IntegrationTest
@DisplayName("Test Service Perfil")
class ProfileServiceTest {
    @Autowired
    private ProfileService sut;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() throws Exception {
        User juan = User.builder()
                .email("juan@example.com")
                .username("juan")
                .password("password")
                .build();
        userRepository.save(juan);

        User pablo = User.builder()
                .email("pablo@example.com")
                .username("pablo")
                .password("password")
                .build();
        userRepository.save(pablo);
    }

    @AfterEach
    void tearDown() throws Exception {
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("test para obetener un perfil.")
    void getProfile() throws Exception {
        // given
        User juan = userRepository.findByEmail("juan@example.com").orElseThrow();
        User pablo = userRepository.findByEmail("pablo@example.com").orElseThrow();

        // when
        ProfileVO pabloProfile = sut.getProfile(juan, pablo);

        // then
        assertThat(pabloProfile.username()).isEqualTo("pablo");
        assertThat(pabloProfile.bio()).isEmpty();
        assertThat(pabloProfile.image()).isNull();
        assertThat(pabloProfile.following()).isFalse();
    }

  
   
}
