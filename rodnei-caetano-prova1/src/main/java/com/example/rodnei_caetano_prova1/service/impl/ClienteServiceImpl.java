package com.example.rodnei_caetano_prova1.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.rodnei_caetano_prova1.dto.ClienteDto;
import com.example.rodnei_caetano_prova1.entity.ClienteEntity;
import com.example.rodnei_caetano_prova1.repository.ClienteRepository;
import com.example.rodnei_caetano_prova1.service.ClienteService;

@Primary
@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository clienteRepo;

	@Override
	public ClienteDto cadastrarCliente(ClienteDto cadastraCliente) {
		var clienteEntity = new ClienteEntity(cadastraCliente);
		clienteRepo.save(clienteEntity);
		return new ClienteDto(clienteEntity);
	}

	@Override
	public List<ClienteDto> buscarClientes() {
		return clienteRepo.findAll().stream().map(ClienteDto::new).toList();
	}

	@Override
	public Optional<ClienteDto> findById(Long id) {
		Optional<ClienteEntity> buscaId = clienteRepo.findById(id);
		return buscaId.map(ClienteDto::new);
	}

	@Override
	public Optional<ClienteEntity> buscaId(Long id) {
		return clienteRepo.findById(id);
	}

	@Override
	public ClienteDto updateCliente(Long id, ClienteDto clienteAtualizado) {
		Optional<ClienteEntity> clienteEntity = clienteRepo.findById(id);
		if(clienteEntity.isPresent()) {
			clienteEntity.get().atualizaCliente(clienteAtualizado);
			var persistedEntity = clienteRepo.save(clienteEntity.get());
			return new ClienteDto(persistedEntity);
		}
		return null;
	}

	
	
}
