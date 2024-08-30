package com.example.rodnei_caetano_prova1.service;

import java.util.List;

import com.example.rodnei_caetano_prova1.dto.ReservaDto;
import com.example.rodnei_caetano_prova1.enuns.StatusEnum;

public interface ReservaService {

	ReservaDto cadastrarReserva(ReservaDto cadastraReserva) throws Exception;
	
	List<ReservaDto> buscarReservas();

	List<ReservaDto> findByClient(Long cliente);

	String verifyTable(Integer mesa);

	ReservaDto updateStatus(StatusEnum status);
	
}
