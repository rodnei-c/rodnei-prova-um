package com.example.rodnei_caetano_prova1.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.example.rodnei_caetano_prova1.dto.RestauranteDto;
import com.example.rodnei_caetano_prova1.enuns.TipoComidaEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "restaurante")
public class RestauranteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false, unique = true)
	private String cnpj;
	
	@Column(nullable = false)
	private Integer estrela;
	
	@Enumerated(EnumType.ORDINAL)
	private TipoComidaEnum tipo_comida;
	
	@OneToMany(mappedBy = "restaurante_id", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private List<ClienteEntity> clientes;
	
	@OneToMany(mappedBy = "restaurante_id", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private List<FuncionarioEntity> funcionarios;
	
	@OneToMany(mappedBy = "restaurante_id", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private List<MesaEntity> mesas;
	
	public RestauranteEntity(RestauranteDto dto) {
		this.id = dto.getId();
		this.cnpj = dto.getCnpj();
		this.estrela = dto.getEstrela();
		this.nome = dto.getNome();
		this.tipo_comida = dto.getTipo_comida();
	}
	
}
