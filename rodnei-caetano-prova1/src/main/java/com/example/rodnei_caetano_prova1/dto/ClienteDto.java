package com.example.rodnei_caetano_prova1.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.rodnei_caetano_prova1.entity.ClienteEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteDto extends PessoaDto{

	private Long id;
	private LocalDate data_cadastro;
	private Integer quantidade_reservas;
	private BigDecimal quantidade_valor_gasto;
	private Boolean flg_bloqueado;
	private Long restaurante_id;
	
	public ClienteDto(ClienteEntity entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.cpf = entity.getCpf();
		this.data_cadastro = entity.getData_cadastro();
		this.data_nascimento = entity.getData_nascimento();
		this.quantidade_valor_gasto = entity.getQuantidade_valor_gasto();
		this.sobrenome = entity.getSobrenome();
		this.telefone = entity.getTelefone();
		this.sexo = entity.getSexo();
		this.flg_bloqueado = entity.getFlg_bloqueado();
		this.restaurante_id = entity.getRestaurante_id().getId();
		
	}
	
}
