package com.example.rodnei_caetano_prova1.repository;

import java.time.LocalDate;
import java.util.List;

import com.example.rodnei_caetano_prova1.dto.MesaDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rodnei_caetano_prova1.entity.MesaEntity;

public interface MesaRepositoryCustom {

	Page<MesaDto> buscaPorCapacidadePessoa(Pageable pageable, String searchTerm, Long restauranteId, Integer capacidadePessoas);

    Page<MesaDto> buscaMesasDisponiveis(Pageable pageable, String searchTerm, LocalDate data, Integer quant_pessoas);

	Page<MesaDto> buscarMesas(Pageable pageable, String searchTerm);
	
}
