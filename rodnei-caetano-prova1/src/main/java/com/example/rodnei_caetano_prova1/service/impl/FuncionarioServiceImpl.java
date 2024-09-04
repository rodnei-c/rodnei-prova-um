package com.example.rodnei_caetano_prova1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.rodnei_caetano_prova1.dto.FuncionarioDto;
import com.example.rodnei_caetano_prova1.entity.FuncionarioEntity;
import com.example.rodnei_caetano_prova1.entity.RestauranteEntity;
import com.example.rodnei_caetano_prova1.repository.FuncionarioRepository;
import com.example.rodnei_caetano_prova1.service.FuncionarioService;
import com.example.rodnei_caetano_prova1.service.RestauranteService;

@Primary
@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	FuncionarioRepository funcionarioRepo;
	
	@Autowired
	RestauranteService restauranteService;
	
	@Override
	public FuncionarioDto criarFuncionario(FuncionarioDto funcionario) {
		var restaurante = validaRestaurante(funcionario.getRestaurante_id());
		var funcionarioEntity = new FuncionarioEntity(funcionario, restaurante);
		funcionarioRepo.save(funcionarioEntity);
		return new FuncionarioDto(funcionarioEntity);
	}

	private RestauranteEntity validaRestaurante(Long id) {
		return restauranteService.buscaPorId(id).orElseThrow(() -> new RuntimeException("Não achou"));
		
	}
}
