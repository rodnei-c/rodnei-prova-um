package com.example.rodnei_caetano_prova1.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.rodnei_caetano_prova1.dto.ClienteDto;
import com.example.rodnei_caetano_prova1.dto.ReservaDto;
import com.example.rodnei_caetano_prova1.entity.ClienteEntity;
import com.example.rodnei_caetano_prova1.entity.ReservaEntity;
import com.example.rodnei_caetano_prova1.enuns.StatusEnum;
import com.example.rodnei_caetano_prova1.repository.ReservaRepository;
import com.example.rodnei_caetano_prova1.service.ClienteService;
import com.example.rodnei_caetano_prova1.service.ReservaService;

@Primary
@Service
public class ReservaServiceImpl implements ReservaService {
	
	@Autowired
	private ReservaRepository reservaRepo;
	
	@Autowired
	private ClienteService clienteService;

	LocalDate dtAtual = LocalDate.now();
	
	@Override
	public ReservaDto cadastrarReserva(ReservaDto cadastraReserva) throws Exception {
		
		/*
		 * Faltou validar de não reservas a mesa no mesmo dia
		 * 
		 * Faltou numero maximo de pessoas
		 * 
		 * Faltou numero maximo de mesa
		 * 
		 * Faltou fazer a mesa ser cancelada com um dia de antecedencia
		 * 
		 * Faltou colocar os campos como NotNull e o Email do cliente como Unique
		 * 
		 * Faltou deixar o status como FEITA
		 * 
		 * Faltou o end-point de alterar o status da reserva
		 * 
		 */
		
		var cliente = validaCliente(cadastraReserva.getCliente());
		var reservaEntity = new ReservaEntity(cadastraReserva, cliente);
		if(reservaEntity.getDataReserva().isBefore(dtAtual)) {
			throw new Exception("não é possível reservar em uma data que já aconteceu");
		}
		ReservaEntity persistedEntity = reservaRepo.save(reservaEntity);
		return new ReservaDto(persistedEntity);
	}

	
	private ClienteEntity validaCliente(Long id) throws RuntimeException{
		return clienteService.buscaId(id).orElseThrow(() -> new RuntimeException("cliente não existe"));
	}

	@Override
	public List<ReservaDto> buscarReservas() {

		return reservaRepo.findAll().stream().map(ReservaDto::new).toList();
	}


	@Override
	public List<ReservaDto> findByClient(Long cliente) {
		return reservaRepo.findAll().stream().map(ReservaDto::new)
				.filter(reserva -> reserva.getCliente().equals(cliente))
				.toList();                                                                            
	}


	@Override
	public String verifyTable(Integer mesa) {
		var reservaMesa = reservaRepo.findAll().stream().map(ReservaDto::new).filter(reserva -> reserva.getNumeroMesa().equals(mesa)).toList();
		if(reservaMesa.isEmpty()) {
			return "Essa mesa está disponível";
		}
		
		return "Essa mesa não está disponível";
	}


	@Override
	public ReservaDto updateStatus(StatusEnum status) {

		return null;
	}
	
}
