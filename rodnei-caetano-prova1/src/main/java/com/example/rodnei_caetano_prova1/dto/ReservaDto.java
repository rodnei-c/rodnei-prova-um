package com.example.rodnei_caetano_prova1.dto;

import java.time.LocalDate;

import com.example.rodnei_caetano_prova1.entity.ReservaEntity;
import com.example.rodnei_caetano_prova1.enuns.StatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservaDto {

	private Long id;
	private LocalDate dataReserva;
	private Integer quantidade_pessoas;
	private StatusEnum status;
	private Long cliente_id;
	private Long mesa_id;
	private String observacao;
	
	public ReservaDto(ReservaEntity entity) {
		this.id = entity.getId();
		this.cliente_id = entity.getCliente_id().getId();
		this.dataReserva = entity.getDataReserva();
		this.mesa_id = entity.getMesa_id().getId();
		this.observacao = entity.getObservacao();
		this.quantidade_pessoas = entity.getQuantidade_pessoas();
		this.status = entity.getStatus();
	}
	
}
