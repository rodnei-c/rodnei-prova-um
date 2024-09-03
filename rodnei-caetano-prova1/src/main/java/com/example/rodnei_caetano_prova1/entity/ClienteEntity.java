package com.example.rodnei_caetano_prova1.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

import com.example.rodnei_caetano_prova1.dto.ClienteDto;

import jakarta.annotation.Nonnull;
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
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "cliente")
public class ClienteEntity extends PessoaEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private LocalDate data_cadastro;
	
	@Column(nullable = false)
	private BigDecimal quantidade_valor_gasto;
	
	@Column(nullable = false)
	private Boolean flg_bloqueado;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "restaurante_id", nullable = false)
	private RestauranteEntity restaurante_id;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private List<ReservaEntity> reservas;
	
	public ClienteEntity(ClienteDto dto, RestauranteEntity restaurante) {
		this.id = dto.getId();
		this.nome = dto.getNome();
		this.cpf = dto.getCpf();
		this.data_cadastro = dto.getData_cadastro();
		this.data_nascimento = dto.getData_nascimento();
		this.quantidade_valor_gasto = dto.getQuantidade_valor_gasto();
		this.sobrenome = dto.getSobrenome();
		this.telefone = dto.getTelefone();
		this.sexo = dto.getSexo();
		this.flg_bloqueado = dto.getFlg_bloqueado();
		this.restaurante_id = restaurante;
		
	}
	
	public ClienteEntity atualizaCliente(ClienteDto dto) {
		this.nome = dto.getNome();
		return this;
	}

	
}
