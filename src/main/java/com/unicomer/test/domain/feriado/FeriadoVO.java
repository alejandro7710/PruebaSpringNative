package com.unicomer.test.domain.feriado;

import java.time.LocalDateTime;

import com.unicomer.test.domain.user.ProfileVO;
import com.unicomer.test.domain.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public record FeriadoVO(int id,
        String title,
        String type,
        int inalienable,
        String extra
        ) {
    public FeriadoVO(User me, Feriado feriado) {
        this(
        		feriado.getId(),
        		feriado.getTitle(),
        		feriado.getType(),
        		feriado.getInalienable(),
        		feriado.getExtra());
    }
}

