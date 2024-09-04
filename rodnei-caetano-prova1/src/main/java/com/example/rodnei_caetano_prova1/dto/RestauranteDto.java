package com.example.rodnei_caetano_prova1.dto;

import com.example.rodnei_caetano_prova1.entity.RestauranteEntity;
import com.example.rodnei_caetano_prova1.enuns.TipoComidaEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RestauranteDto {

	private Long id;
	private String nome;
	private String cnpj;
	private Integer estrela;
	private TipoComidaEnum tipo_comida;
	
	public RestauranteDto(RestauranteEntity entity) {
		this.id = entity.getId();
		this.cnpj = entity.getCnpj();
		this.estrela = entity.getEstrela();
		this.nome = entity.getNome();
		this.tipo_comida = entity.getTipo_comida();
	}
}
