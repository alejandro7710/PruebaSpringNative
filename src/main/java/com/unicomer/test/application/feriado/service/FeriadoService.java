package com.unicomer.test.application.feriado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unicomer.test.domain.feriado.CreateFeriadoRequest;
import com.unicomer.test.domain.feriado.Feriado;
import com.unicomer.test.domain.feriado.FeriadoFacets;
import com.unicomer.test.domain.feriado.FeriadoRepository;
import com.unicomer.test.domain.feriado.FeriadoVO;
import com.unicomer.test.domain.user.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FeriadoService {
	@Autowired
	private  FeriadoRepository feriadoRepository;
    @Transactional
    public FeriadoVO createFeriado(User me, CreateFeriadoRequest request) {
        Feriado newFeriado = new Feriado();
        newFeriado.setTitle(request.title());
        newFeriado.setType(request.type());
        newFeriado.setInalienable(request.inalienable());
        newFeriado.setExtra(request.extra());

     

        newFeriado = feriadoRepository.save(newFeriado);
        return new FeriadoVO(me, newFeriado);
    }

	
	  @Transactional(readOnly = true)
	    public List<FeriadoVO> getFeriados(User me, FeriadoFacets facets) {
	        String title = facets.title();
	        String type = facets.type();
	        Pageable pageable = facets.getPageable();

	        Page<Feriado> byFacets = feriadoRepository.findByFacets(title, type, pageable);
	        return byFacets.getContent().stream()
	                .map(feriado -> new FeriadoVO(me, feriado))
	                .toList();
	    }


}
