package com.example.rodnei_caetano_prova1.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.example.rodnei_caetano_prova1.dto.MesaDto;
import com.example.rodnei_caetano_prova1.entity.MesaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MesaService {

	MesaDto criarMesa(MesaDto mesa);
	
	Optional<MesaEntity> buscaId(Long id);

	List<MesaDto> listarMesas(Pageable pageable, String searchTerm);

	List<MesaDto> buscaPorCapacidadePessoa(Pageable pageable, String searchTerm, Long restauranteId, Integer capacidadePessoas, LocalDate data);

}
