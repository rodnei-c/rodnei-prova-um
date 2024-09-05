package com.example.rodnei_caetano_prova1.repository;

import com.example.rodnei_caetano_prova1.dto.RestauranteDto;
import com.example.rodnei_caetano_prova1.entity.RestauranteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RestauranteRepositoryCustom {

    Page<RestauranteDto> buscaRestaurantes(Pageable pageable, String searchTerm);

}
