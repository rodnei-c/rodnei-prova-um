package com.example.rodnei_caetano_prova1.dto;

import com.example.rodnei_caetano_prova1.entity.ClienteEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteDto {

	private Long id;
	private String nome;
	private String email;
	
	public ClienteDto(ClienteEntity entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.email = entity.getEmail();
	}
	
}
