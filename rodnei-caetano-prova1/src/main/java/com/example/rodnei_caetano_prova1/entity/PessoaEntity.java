package com.example.rodnei_caetano_prova1.entity;

import java.time.LocalDate;

import com.example.rodnei_caetano_prova1.enuns.SexoEnum;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
	
	@Column(nullable = true, unique = true)
	protected String cpf;
	
	protected String sobrenome;
	protected LocalDate data_nascimento;
	
	@Enumerated(EnumType.ORDINAL)
	protected SexoEnum sexo;
	
	protected String telefone;
	
}
