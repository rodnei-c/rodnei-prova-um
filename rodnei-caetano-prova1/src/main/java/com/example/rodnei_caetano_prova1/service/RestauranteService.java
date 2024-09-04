package com.example.rodnei_caetano_prova1.service;

import java.util.Optional;

import com.example.rodnei_caetano_prova1.dto.RestauranteDto;
import com.example.rodnei_caetano_prova1.entity.RestauranteEntity;

public interface RestauranteService {

	RestauranteDto criarRestaurante(RestauranteDto restaurante);

	Optional<RestauranteEntity> buscaPorId(Long id);
	
}
