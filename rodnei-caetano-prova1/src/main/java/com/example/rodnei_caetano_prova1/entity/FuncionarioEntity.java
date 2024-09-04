package com.example.rodnei_caetano_prova1.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.rodnei_caetano_prova1.dto.FuncionarioDto;
import com.example.rodnei_caetano_prova1.enuns.CargoEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "funcionario")
public class FuncionarioEntity extends PessoaEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Enumerated(EnumType.ORDINAL)
	private CargoEnum cargo;
	
	@Column(nullable = false)
	private LocalDate data_admissao;
	
	@Column(nullable = false)
	private BigDecimal salario;
	
	@Column(nullable = false)
	private Integer carga_horaria;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "restaurante_id", nullable = false)
	private RestauranteEntity restaurante_id;
	
	public FuncionarioEntity(FuncionarioDto dto, RestauranteEntity restaurante) {
		this.carga_horaria = dto.getCarga_horaria();
		this.cargo = dto.getCargo();
		this.cpf = dto.getCpf();
		this.data_admissao = dto.getData_admissao();
		this.data_nascimento = dto.getData_nascimento();
		this.id = dto.getId();
		this.nome = dto.getNome();
		this.restaurante_id = restaurante;
		this.salario = dto.getSalario();
		this.sexo = dto.getSexo();
		this.sobrenome = dto.getSobrenome();
		this.telefone = dto.getTelefone();
	}
	
}
