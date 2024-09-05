package com.example.rodnei_caetano_prova1.entity;

import java.time.LocalDate;
import java.util.List;

import com.example.rodnei_caetano_prova1.dto.ReservaDto;
import com.example.rodnei_caetano_prova1.enuns.StatusEnum;

import jakarta.annotation.Nonnull;
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
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "reserva")
public class ReservaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private LocalDate dataReserva;

	@Column(nullable = false)
	private Integer quantidade_pessoas;

	@Enumerated(EnumType.ORDINAL)
	private StatusEnum status;
	
	@Column(nullable = false)
	private String observacao;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "cliente_id", nullable = false)
	private ClienteEntity cliente_id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "mesa_id", nullable = false)
	private MesaEntity mesa_id;
	
	@OneToMany(mappedBy = "reserva_id", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private List<PedidoEntity> pedidos;

	public ReservaEntity(ReservaDto dto, ClienteEntity cliente, MesaEntity mesa) {
		this.id = dto.getId();
		this.cliente_id = cliente;
		this.dataReserva = dto.getDataReserva();
		this.quantidade_pessoas = dto.getQuantidade_pessoas();
		this.mesa_id = mesa;
		this.status = StatusEnum.AGENDADA;
		this.observacao = dto.getObservacao();
	}

	public ReservaEntity AtualizarStatus(StatusEnum status) {
		this.status = status;
//		validaCancelamento(status);
		return this;
	}

}
