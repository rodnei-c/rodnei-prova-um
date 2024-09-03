package com.example.rodnei_caetano_prova1.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PedidoDto {

	private Long id;
	private Long reserva_id;
	private String descricao;
	private BigDecimal valor;
	
}
