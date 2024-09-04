package com.example.rodnei_caetano_prova1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.rodnei_caetano_prova1.dto.PedidoDto;
import com.example.rodnei_caetano_prova1.entity.PedidoEntity;
import com.example.rodnei_caetano_prova1.entity.ReservaEntity;
import com.example.rodnei_caetano_prova1.repository.PedidoRepository;
import com.example.rodnei_caetano_prova1.service.PedidoService;
import com.example.rodnei_caetano_prova1.service.ReservaService;

@Primary
@Service
public class PedidoServiceImpl implements PedidoService{
	
	@Autowired
	PedidoRepository pedidoRepo;
	
	@Autowired
	ReservaService reservaService;

	@Override
	public PedidoDto criarPedido(PedidoDto pedido) {
		var reserva = validaReserva(pedido.getReserva_id());
		var pedidoEntity = new PedidoEntity(pedido, reserva);
		pedidoRepo.save(pedidoEntity);
		return new PedidoDto(pedidoEntity);
	}
	
	private ReservaEntity validaReserva(Long id) {
		return reservaService.buscaId(id).orElseThrow(() -> new RuntimeException("Não achou"));
	}

}
