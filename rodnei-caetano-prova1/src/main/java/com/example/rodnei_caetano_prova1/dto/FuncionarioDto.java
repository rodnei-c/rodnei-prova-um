package com.example.rodnei_caetano_prova1.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

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
	
}
