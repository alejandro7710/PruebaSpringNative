package com.unicomer.test.application.feriado.controller;


import java.util.List;

import com.unicomer.test.domain.feriado.FeriadoVO;

public record MultipleFeriadosResponse(FeriadoVO[] feriados, int feriadosCount) {
    public MultipleFeriadosResponse(List<FeriadoVO> feriados) {
        this(feriados.toArray(FeriadoVO[]::new), feriados.size());
    }

	
}
