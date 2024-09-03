package com.example.rodnei_caetano_prova1.dto;

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
	
}
