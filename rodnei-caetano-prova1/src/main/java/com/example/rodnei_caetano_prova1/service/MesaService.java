package com.example.rodnei_caetano_prova1.service;

import java.util.Optional;

import com.example.rodnei_caetano_prova1.dto.MesaDto;
import com.example.rodnei_caetano_prova1.entity.MesaEntity;

public interface MesaService {

	MesaDto criarMesa(MesaDto mesa);
	
	Optional<MesaEntity> buscaId(Long id);
	
}
