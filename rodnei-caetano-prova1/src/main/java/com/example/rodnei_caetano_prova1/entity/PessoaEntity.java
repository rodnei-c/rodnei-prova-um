package com.example.rodnei_caetano_prova1.entity;

import java.time.LocalDate;

import com.example.rodnei_caetano_prova1.enuns.SexoEnum;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@MappedSuperclass
public abstract class PessoaEntity {

	protected String nome;
	protected String cpf;
	protected String sobrenome;
	protected LocalDate data_nascimento;
	protected SexoEnum sexo;
	protected String telefone;
	
}
