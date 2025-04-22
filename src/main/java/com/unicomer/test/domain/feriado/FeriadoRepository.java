package com.unicomer.test.domain.feriado;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface FeriadoRepository extends JpaRepository<Feriado, Integer> {
  //  boolean existsByName(String name);

//    Optional<Feriado> findByName(String name);
    
    @Query("SELECT a FROM Feriado a")
    Page<Feriado> findByFacets(
            @Param("title") String tag,
            @Param("type") String author,
            Pageable pageable);
}
