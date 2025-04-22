package com.unicomer.test.domain.feriado;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public record FeriadoFacets(String title, String type, int offset, int limit) {
    public FeriadoFacets {
        if (offset < 0) {
            offset = 0;
        }

        if (limit < 0 || limit > 100) {
            limit = 20;
        }
    }

    public Pageable getPageable() {
        return PageRequest.of(offset, limit);
    }
}
