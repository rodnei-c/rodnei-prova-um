package com.example.rodnei_caetano_prova1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rodnei_caetano_prova1.dto.PedidoDto;
import com.example.rodnei_caetano_prova1.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	PedidoService pedidoService;
	
	@PostMapping("/cadastrarPedido")
	public PedidoDto criarPedido(@RequestBody PedidoDto pedido) {
		return pedidoService.criarPedido(pedido);
	}
}
