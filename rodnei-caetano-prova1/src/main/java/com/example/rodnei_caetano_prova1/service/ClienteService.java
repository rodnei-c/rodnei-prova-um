package com.example.rodnei_caetano_prova1.service;

import java.util.List;
import java.util.Optional;

import com.example.rodnei_caetano_prova1.dto.ClienteDto;
import com.example.rodnei_caetano_prova1.entity.ClienteEntity;

public interface ClienteService {

	ClienteDto cadastrarCliente(ClienteDto cadastraCliente);
	
	List<ClienteDto> buscarClientes();
	
	Optional<ClienteDto> findById(Long id);
	
	Optional<ClienteEntity> buscaId(Long id);

	ClienteDto updateCliente(Long id, ClienteDto clienteAtualizado);
	
}
