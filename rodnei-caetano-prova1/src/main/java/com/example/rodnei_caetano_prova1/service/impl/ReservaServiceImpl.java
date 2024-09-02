package com.example.rodnei_caetano_prova1.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.example.rodnei_caetano_prova1.dto.ReservaDto;
import com.example.rodnei_caetano_prova1.entity.ClienteEntity;
import com.example.rodnei_caetano_prova1.entity.ReservaEntity;
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
		
		var cliente = validaCliente(cadastraReserva.getCliente());
		var reservaEntity = new ReservaEntity(cadastraReserva, cliente);
		validaReserva(cadastraReserva);
		validaPessoas(cadastraReserva);
		validaMesaQuant(cadastraReserva);
		validaDatasDiferentes(cadastraReserva);
		ReservaEntity persistedEntity = reservaRepo.save(reservaEntity);
		return new ReservaDto(persistedEntity);
	}
	
	private void validaDatasDiferentes(ReservaDto reserva) throws Exception {
		List<ReservaDto> listaData = reservaRepo.findAll().stream().filter(e -> e.getDataReserva().equals(reserva.getDataReserva())
				&& e.getNumeroMesa().equals(reserva.getNumeroMesa()) && e.getStatus().equals(reserva.getStatus().FEITA))
		.map(ReservaDto::new).toList();
		if(!listaData.isEmpty()) {
			throw new Exception("Não é possível reservas a mesma mesa no mesmo dia");
		}
	};

	private void validaReserva(ReservaDto reserva) throws Exception {
		if(reserva.getDataReserva().isBefore(dtAtual)) {
			throw new Exception("não é possível reservar em uma data que já aconteceu");
		}
	}
	
	private void validaPessoas(ReservaDto reserva) throws Exception {
		if(reserva.getNumeroPessoas() < 1) {
			throw new Exception("Para reservar uma mesa precisa de no mínimo uma pessoa");
		} else if(reserva.getNumeroPessoas() > 10) {
			throw new Exception("Uma mesa pode ter no máximo 10 pessoas");
		}
	}
	
	private void validaMesaQuant(ReservaDto reserva) throws Exception {
		if(reserva.getNumeroMesa() < 1 || reserva.getNumeroMesa() > 20) {
			throw new Exception("Está mesa não existe");
		}
	}
	
	private ClienteEntity validaCliente(Long id) throws Exception{
		return clienteService.buscaId(id).orElseThrow(() -> new Exception("cliente não existe"));
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
	public ReservaDto updateStatus(Long id, ReservaDto reserva) {
		Optional<ReservaEntity> atualizaStatus = reservaRepo.findById(id);
		if(atualizaStatus.isPresent()) {
			atualizaStatus.get().AtualizarStatus(reserva);		
			var persistedEntity = reservaRepo.save(atualizaStatus.get());
			try {
				validaCancelamento(reserva);
			} catch (Exception e) {
				e.getMessage();
			}
			return new ReservaDto(persistedEntity);
		}
		return null;
	}
	
	private void validaCancelamento(ReservaDto reserva) throws Exception {
		LocalDate dtCancel = reserva.getDataReserva();
		if(reserva.getDataReserva().isBefore(dtCancel.minusDays(1))) {
			if(reserva.getStatus().equals(reserva.getStatus().CANCELADA)) {
				throw new Exception("Não é possível cancelar a reserva");
			}
		}
	}
	
	
	
}
