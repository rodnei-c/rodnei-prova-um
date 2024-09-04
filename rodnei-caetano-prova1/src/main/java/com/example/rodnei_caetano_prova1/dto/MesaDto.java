package com.example.rodnei_caetano_prova1.dto;

import com.example.rodnei_caetano_prova1.entity.MesaEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MesaDto {

	private Long id;
	private Integer numero;
	private Integer capacidade_pessoas;
	private Long restaurante_id;
	
	public MesaDto(MesaEntity entity) {
		this.capacidade_pessoas = entity.getCapacidade_pessoas();
		this.id = entity.getId();
		this.numero = entity.getNumero();
		this.restaurante_id = entity.getRestaurante_id().getId();
	}
	
}
