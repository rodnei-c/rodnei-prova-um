package com.example.rodnei_caetano_prova1.dto;

import java.time.LocalDate;

import com.example.rodnei_caetano_prova1.enuns.SexoEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class PessoaDto {

	protected String nome;
	protected String cpf;
	protected String sobrenome;
	protected LocalDate data_nascimento;
	protected SexoEnum sexo;
	protected String telefone;
	
}
