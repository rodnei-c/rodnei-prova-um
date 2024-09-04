package com.example.rodnei_caetano_prova1.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.rodnei_caetano_prova1.entity.FuncionarioEntity;
import com.example.rodnei_caetano_prova1.enuns.CargoEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FuncionarioDto extends PessoaDto{

	private Long id;
	private CargoEnum cargo;
	private LocalDate data_admissao;
	private BigDecimal salario;
	private Integer carga_horaria;
	private Long restaurante_id;
	
	public FuncionarioDto(FuncionarioEntity entity) {
		this.carga_horaria = entity.getCarga_horaria();
		this.cargo = entity.getCargo();
		this.cpf = entity.getCpf();
		this.data_admissao = entity.getData_admissao();
		this.data_nascimento = entity.getData_nascimento();
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.restaurante_id = entity.getRestaurante_id().getId();
		this.salario = entity.getSalario();
		this.sexo = entity.getSexo();
		this.sobrenome = entity.getSobrenome();
		this.telefone = entity.getTelefone();
	}
	
}
