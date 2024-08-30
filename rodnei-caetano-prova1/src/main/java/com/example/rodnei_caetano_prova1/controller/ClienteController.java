package com.example.rodnei_caetano_prova1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rodnei_caetano_prova1.dto.ClienteDto;
import com.example.rodnei_caetano_prova1.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@PostMapping("/cadastrarCliente")
	public ClienteDto cadastrarCliente(@RequestBody ClienteDto cadastraCliente) {
		return clienteService.cadastrarCliente(cadastraCliente);
	}
	
	@GetMapping("/buscarClientes")
	public List<ClienteDto> buscarClientes(){
		return clienteService.buscarClientes();
		
	}
	
	@GetMapping("/{id}")
	public Optional<ClienteDto> buscarPorId(@PathVariable Long id){
		Optional<ClienteDto> cliente = clienteService.findById(id);
		return cliente;
	}
	
	@PutMapping("/{id}")
	public ClienteDto atualizarCliente(@PathVariable Long id, @RequestBody ClienteDto clienteAtualizado) {
		return clienteService.updateCliente(id, clienteAtualizado);
	}
	
}
