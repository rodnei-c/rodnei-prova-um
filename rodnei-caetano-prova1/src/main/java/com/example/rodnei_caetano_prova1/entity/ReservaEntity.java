package com.example.rodnei_caetano_prova1.entity;

import java.time.LocalDate;

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
	private Integer numeroPessoas;

	@Column(nullable = false)
	private Integer numeroMesa;

	@Enumerated(EnumType.ORDINAL)
	private StatusEnum status;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "cliente_id", nullable = false)
	private ClienteEntity cliente;

	public ReservaEntity(ReservaDto dto, ClienteEntity cliente) {
		this.id = dto.getId();
		this.cliente = cliente;
		this.dataReserva = dto.getDataReserva();
		this.numeroMesa = dto.getNumeroMesa();
		this.numeroPessoas = dto.getNumeroPessoas();
		this.status = StatusEnum.FEITA;
	}

	public ReservaEntity AtualizarStatus(StatusEnum status) {
		this.status = status;
//		validaCancelamento(status);
		return this;
	}

}
