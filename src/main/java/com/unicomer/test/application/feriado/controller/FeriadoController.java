package com.unicomer.test.application.feriado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unicomer.test.application.feriado.service.FeriadoService;
import com.unicomer.test.domain.feriado.CreateFeriadoRequest;
import com.unicomer.test.domain.feriado.Feriado;
import com.unicomer.test.domain.feriado.FeriadoFacets;
import com.unicomer.test.domain.feriado.FeriadoVO;
import com.unicomer.test.domain.feriado.SingleFeriadoResponse;
import com.unicomer.test.domain.user.User;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class FeriadoController {
	
	@Autowired
    private  FeriadoService feriadoService;
	
	 @PostMapping("/api/feriados")
	    public SingleFeriadoResponse createFeriado(User me, @RequestBody CreateFeriadoRequest request) {
	        FeriadoVO feriado = feriadoService.createFeriado(me, request);
	        return new SingleFeriadoResponse(feriado);
	    }
	  @GetMapping("/api/feriados")
	    public MultipleFeriadosResponse getFeriados(
	            User me,
	            @RequestParam(value = "title", required = false) String title,
	            @RequestParam(value = "type", required = false) String type,
	            @RequestParam(value = "limit", required = false, defaultValue = "20") int limit,
	            @RequestParam(value = "offset", required = false, defaultValue = "0") int offset) {
		 
		  FeriadoFacets facets = new FeriadoFacets(title, type, offset, limit);
	        List<FeriadoVO> feriados = feriadoService.getFeriados(me, facets);
	        return new MultipleFeriadosResponse(feriados);
	    }


}
