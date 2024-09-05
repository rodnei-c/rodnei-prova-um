package com.example.rodnei_caetano_prova1.service;

import java.util.List;
import java.util.Optional;

import com.example.rodnei_caetano_prova1.dto.RestauranteDto;
import com.example.rodnei_caetano_prova1.entity.RestauranteEntity;
import org.springframework.data.domain.Pageable;

public interface RestauranteService {

	RestauranteDto criarRestaurante(RestauranteDto restaurante);

	Optional<RestauranteEntity> buscaPorId(Long id);

	List<RestauranteDto> listarRestaurantes(Pageable pageable, String searchTerm);
}
