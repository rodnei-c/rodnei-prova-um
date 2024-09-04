package com.example.rodnei_caetano_prova1.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.rodnei_caetano_prova1.dto.RestauranteDto;
import com.example.rodnei_caetano_prova1.entity.RestauranteEntity;
import com.example.rodnei_caetano_prova1.repository.RestauranteRepository;
import com.example.rodnei_caetano_prova1.service.RestauranteService;

@Primary
@Service
public class RestauranteServiceImpl implements RestauranteService{

	@Autowired
	private RestauranteRepository restauranteRepo;
	
	@Override
	public RestauranteDto criarRestaurante(RestauranteDto restaurante) {
		var restauranteEntity = new RestauranteEntity(restaurante);
		restauranteRepo.save(restauranteEntity);
		return new RestauranteDto(restauranteEntity);
	}
	
	@Override
	public Optional<RestauranteEntity> buscaPorId(Long id) {
		return restauranteRepo.findById(id);
	}

}
