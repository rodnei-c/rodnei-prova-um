package com.example.rodnei_caetano_prova1.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.example.rodnei_caetano_prova1.dto.ReservaDto;
import com.example.rodnei_caetano_prova1.entity.ClienteEntity;
import com.example.rodnei_caetano_prova1.entity.MesaEntity;
import com.example.rodnei_caetano_prova1.entity.ReservaEntity;
import com.example.rodnei_caetano_prova1.enuns.StatusEnum;
import com.example.rodnei_caetano_prova1.repository.ReservaRepository;
import com.example.rodnei_caetano_prova1.service.ClienteService;
import com.example.rodnei_caetano_prova1.service.MesaService;
import com.example.rodnei_caetano_prova1.service.ReservaService;

@Primary
@Service
public class ReservaServiceImpl implements ReservaService {
	
	@Autowired
	private ReservaRepository reservaRepo;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private MesaService mesaService;

	LocalDate dtAtual = LocalDate.now();
	
	@Override
	public ReservaDto cadastrarReserva(ReservaDto cadastraReserva) throws Exception {
		
		var cliente = validaCliente(cadastraReserva.getCliente_id());
		var mesa = validaMesa(cadastraReserva.getMesa_id());
		var reservaEntity = new ReservaEntity(cadastraReserva, cliente, mesa);
		validaReserva(cadastraReserva);
		validaPessoas(cadastraReserva);
		validaMesaQuant(cadastraReserva);
		validaDatasDiferentes(cadastraReserva);
		ReservaEntity persistedEntity = reservaRepo.save(reservaEntity);
		return new ReservaDto(persistedEntity);
	}
	
	public MesaEntity validaMesa(Long id) {
		return mesaService.buscaId(id).orElseThrow(() -> new RuntimeException("Não achou"));
	}

	@Override
	public List<ReservaDto> buscarReservas() {

		return reservaRepo.findAll().stream().map(ReservaDto::new).toList();
	}


	@Override
	public List<ReservaDto> findByClient(Long cliente) {
//		return reservaRepo.findAll().stream().map(ReservaDto::new)
//				.filter(reserva -> reserva.getCliente().equals(cliente))
//				.toList();        
		return null;
	}


	@Override
	public String verifyTable(Integer mesa) {
//		var reservaMesa = reservaRepo.findAll().stream().map(ReservaDto::new).filter(reserva -> reserva.getNumeroMesa().equals(mesa)
//				&& !reserva.getStatus().equals(StatusEnum.AGENDADA)).toList();
//		if(reservaMesa.isEmpty()) {
//			return "Essa mesa está disponível";
//		}
//		
//		return "Essa mesa não está disponível";
		return null;
	}


	@Override
	public ReservaDto updateStatus(Long id, StatusEnum status) throws Exception {
		Optional<ReservaEntity> atualizaStatus = reservaRepo.findById(id);
		
		if(atualizaStatus.isPresent()) {
			if(status.equals(StatusEnum.CANCELADA)) {
			validaCancelamento(atualizaStatus.get().getDataReserva());
			} else if(status.equals(StatusEnum.CONCLUIDA)) {
			validaConclusao(atualizaStatus.get().getDataReserva());
			}
			atualizaStatus.get().AtualizarStatus(status);
			var persistedEntity = reservaRepo.save(atualizaStatus.get());
			return new ReservaDto(persistedEntity);
		}
		return null;
		
	}
	
	private void validaDatasDiferentes(ReservaDto reserva) throws Exception {
//		List<ReservaDto> listaData = reservaRepo.findAll().stream().filter(e -> e.getDataReserva().equals(reserva.getDataReserva())
//				&& e.getNumeroMesa().equals(reserva.getNumeroMesa()) && e.getStatus().equals(reserva.getStatus().AGENDADA))
//		.map(ReservaDto::new).toList();
//		if(!listaData.isEmpty()) {
//			throw new Exception("Não é possível reservas a mesma mesa no mesmo dia");
//		}
	};

	private void validaReserva(ReservaDto reserva) throws Exception {
		if(reserva.getDataReserva().isBefore(dtAtual)) {
			throw new Exception("não é possível reservar em uma data que já aconteceu");
		}
	}
	
	private void validaPessoas(ReservaDto reserva) throws Exception {
//		if(reserva.getNumeroPessoas() < 1) {
//			throw new Exception("Para reservar uma mesa precisa de no mínimo uma pessoa");
//		} else if(reserva.getNumeroPessoas() > 10) {
//			throw new Exception("Uma mesa pode ter no máximo 10 pessoas");
//		}
	}
	
	private void validaMesaQuant(ReservaDto reserva) throws Exception {
//		if(reserva.getNumeroMesa() < 1 || reserva.getNumeroMesa() > 20) {
//			throw new Exception("Está mesa não existe");
//		}
	}
	
	private ClienteEntity validaCliente(Long id) throws Exception{
		return clienteService.buscaId(id).orElseThrow(() -> new Exception("cliente não existe"));
	}
	
	private void validaCancelamento(LocalDate dataReserva) throws Exception {
		if (dataReserva.isBefore(LocalDate.now()) || dataReserva.equals(LocalDate.now())) {
			throw new Exception("Só é possível cancelar com um dia de antecedência");
		}
	}
	
	private void validaConclusao(LocalDate dataReserva) throws Exception {
		if(dataReserva.isAfter(LocalDate.now())) {
			throw new Exception("Não é possível concluir uma reserva que não ocorreu");
		}
	}

	@Override
	public Optional<ReservaEntity> buscaId(Long id) {
		return reservaRepo.findById(id);
	}
	
	
	
}
