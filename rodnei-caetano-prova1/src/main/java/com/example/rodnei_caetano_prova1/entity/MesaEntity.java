package com.example.rodnei_caetano_prova1.entity;

import java.util.List;

import com.example.rodnei_caetano_prova1.dto.MesaDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "mesa")
public class MesaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private Integer numero;
	
	@Column(nullable = false)
	private Integer capacidade_pessoas;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "restaurante_id", nullable = false)
	private RestauranteEntity restaurante_id;
	
	@OneToMany(mappedBy = "mesa_id", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private List<ReservaEntity> reservas;
	
	public MesaEntity(MesaDto dto, RestauranteEntity restaurante) {
		this.capacidade_pessoas = dto.getCapacidade_pessoas();
		this.id = dto.getId();
		this.numero = dto.getNumero();
		this.restaurante_id = restaurante;
	}
}
