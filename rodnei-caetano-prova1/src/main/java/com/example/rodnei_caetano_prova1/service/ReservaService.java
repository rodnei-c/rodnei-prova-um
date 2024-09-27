package com.example.rodnei_caetano_prova1.service;

import java.util.List;
import java.util.Optional;

import com.example.rodnei_caetano_prova1.dto.ReservaDto;
import com.example.rodnei_caetano_prova1.entity.ReservaEntity;
import com.example.rodnei_caetano_prova1.enuns.StatusEnum;
import org.springframework.data.domain.Pageable;

public interface ReservaService {

	ReservaDto cadastrarReserva(ReservaDto cadastraReserva) throws Exception;
	
	List<ReservaDto> buscarReservas();

	List<ReservaDto> findByClient(Long cliente);

	String verifyTable(Integer mesa);

	ReservaDto updateStatus(Long id, StatusEnum status) throws Exception;
	
	Optional<ReservaEntity> buscaId(Long id);

	List<ReservaDto> buscaObservacao(Pageable pageable, String searchTerm, Long idRestaurante, String descricao);
	
}
