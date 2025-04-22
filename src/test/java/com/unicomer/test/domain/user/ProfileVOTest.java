package com.unicomer.test.domain.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.unicomer.test.domain.user.ProfileVO;
import com.unicomer.test.domain.user.User;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("The ProfileVO")
class ProfileVOTest {
    @Test
    @DisplayName("prueba de constructor ok.")
    void constructor() {
        // when
        ProfileVO simpsonProfile =
                new ProfileVO("pablo", "nombre pablo.", "https://example.com/image.jpg", false);

        // then
        assertThat(simpsonProfile.username()).isEqualTo("pablo");
        assertThat(simpsonProfile.bio()).isEqualTo("nombre pablo.");
        assertThat(simpsonProfile.image()).isEqualTo("https://example.com/image.jpg");
        assertThat(simpsonProfile.following()).isFalse();
    }

}
