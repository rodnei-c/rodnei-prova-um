package com.example.rodnei_caetano_prova1.repository.impl;

import java.util.List;

import com.example.rodnei_caetano_prova1.entity.MesaEntity;
import com.example.rodnei_caetano_prova1.entity.QMesaEntity;
import com.example.rodnei_caetano_prova1.entity.QReservaEntity;
import com.example.rodnei_caetano_prova1.entity.QRestauranteEntity;
import com.example.rodnei_caetano_prova1.repository.MesaRepositoryCustom;
import com.querydsl.jpa.impl.JPAQuery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class MesaRepositoryImpl implements MesaRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
	
	final QMesaEntity mesa = QMesaEntity.mesaEntity;
	final QReservaEntity reserva = QReservaEntity.reservaEntity;
	final QRestauranteEntity restaurante = QRestauranteEntity.restauranteEntity;

	@Override
	public List<MesaEntity> buscaPorCapacidadePessoa(Long restauranteId, Integer capacidadePessoas) {
		var query = new JPAQuery<MesaEntity>(em);
		
		query.select(mesa).distinct().from(restaurante)
				.join(restaurante).where(restaurante.id.eq(restauranteId)
				.and(mesa.capacidade_pessoas.eq(capacidadePessoas)));
				

		return query.fetch();
	}	
	
}
