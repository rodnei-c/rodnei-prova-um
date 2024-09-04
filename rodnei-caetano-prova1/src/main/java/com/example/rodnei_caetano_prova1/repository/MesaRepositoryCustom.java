package com.example.rodnei_caetano_prova1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rodnei_caetano_prova1.entity.MesaEntity;

public interface MesaRepositoryCustom {

	List<MesaEntity> buscaPorCapacidadePessoa(Long restauranteId, Integer capacidadePessoas);
	
}
