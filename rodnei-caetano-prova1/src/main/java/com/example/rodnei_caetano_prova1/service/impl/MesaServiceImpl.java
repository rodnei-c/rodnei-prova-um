package com.example.rodnei_caetano_prova1.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.rodnei_caetano_prova1.dto.MesaDto;
import com.example.rodnei_caetano_prova1.entity.MesaEntity;
import com.example.rodnei_caetano_prova1.entity.RestauranteEntity;
import com.example.rodnei_caetano_prova1.repository.MesaRepository;
import com.example.rodnei_caetano_prova1.service.MesaService;
import com.example.rodnei_caetano_prova1.service.RestauranteService;

@Primary
@Service
public class MesaServiceImpl implements MesaService{

	@Autowired
	MesaRepository mesaRepo;

	@Autowired
	RestauranteService restauranteService;
	
	@Override
	public MesaDto criarMesa(MesaDto mesa) {
		var restaurante = validaRestaurante(mesa.getRestaurante_id());
		var mesaEntity = new MesaEntity(mesa, restaurante);
		mesaRepo.save(mesaEntity);
		return new MesaDto(mesaEntity);
	}
	
	private RestauranteEntity validaRestaurante(Long id) {
		return restauranteService.buscaPorId(id).orElseThrow(() -> new RuntimeException("Não achou"));
	}

	@Override
	public Optional<MesaEntity> buscaId(Long id) {
		return mesaRepo.findById(id);
	}

	@Override
	public List<MesaDto> listarMesas(Pageable pageable, String searchTerm) {
		return mesaRepo.buscarMesas(pageable, searchTerm).stream().toList();
	}

	@Override
	public List<MesaDto> buscaPorCapacidadePessoa(Pageable pageable, String searchTerm, Long restauranteId, Integer capacidadePessoas, LocalDate data) {
		return mesaRepo.buscaPorCapacidadePessoa(pageable, searchTerm, restauranteId, capacidadePessoas, data).stream().toList();
	}


}
