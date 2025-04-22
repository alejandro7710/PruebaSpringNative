package com.unicomer.test.domain.feriado;

import static java.util.stream.Collectors.toSet;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("feriado")
public record CreateFeriadoRequest(String title, String type,int inalienable,String extra) {
  
}
