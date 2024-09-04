package com.example.rodnei_caetano_prova1.entity;

import java.math.BigDecimal;

import com.example.rodnei_caetano_prova1.dto.PedidoDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Entity(name = "pedido")
public class PedidoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private BigDecimal valor;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "reserva_id", nullable = false)
	private ReservaEntity reserva_id;
	
	public PedidoEntity(PedidoDto dto, ReservaEntity reserva) {
		this.descricao = dto.getDescricao();
		this.id = dto.getId();
		this.reserva_id = reserva;
		this.valor = dto.getValor();
	}
}
