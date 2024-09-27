package com.example.rodnei_caetano_prova1.repository.impl;

import java.time.LocalDate;
import java.util.List;

import com.example.rodnei_caetano_prova1.dto.MesaDto;
import com.example.rodnei_caetano_prova1.entity.MesaEntity;
import com.example.rodnei_caetano_prova1.entity.QMesaEntity;
import com.example.rodnei_caetano_prova1.entity.QReservaEntity;

import com.example.rodnei_caetano_prova1.entity.QRestauranteEntity;
import com.example.rodnei_caetano_prova1.enuns.StatusEnum;
import com.example.rodnei_caetano_prova1.repository.MesaRepositoryCustom;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class MesaRepositoryImpl implements MesaRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    final QMesaEntity mesa = QMesaEntity.mesaEntity;
    final QReservaEntity reserva = QReservaEntity.reservaEntity;
    final QRestauranteEntity restaurante = QRestauranteEntity.restauranteEntity;

    @Override
    public Page<MesaDto> buscaPorCapacidadePessoa(Pageable pageable, String searchTerm, Long restauranteId, Integer capacidadePessoas, LocalDate data) {

        JPAQuery<MesaDto> query = new JPAQuery<>(em);

        query.select(Projections.constructor(MesaDto.class, mesa))
                .distinct()
                .from(restaurante)
                .join(restaurante.mesas, mesa)
                .leftJoin(mesa.reservas, reserva)
                .where(restaurante.id.eq(restauranteId)
                        .and(mesa.capacidade_pessoas.goe(capacidadePessoas))
                        .and(reserva.dataReserva.eq(data).not().or(reserva.status.eq(StatusEnum.CANCELADA))));


        query.limit(pageable.getPageSize());
        query.offset(pageable.getOffset());

        return new PageImpl<>(query.fetch(), pageable, query.fetchCount());
    }

    @Override
    public Page<MesaDto> buscarMesas(Pageable pageable, String searchTerm) {

        JPAQuery<MesaDto> query = new JPAQuery<>(em);

        query.select(Projections.constructor(MesaDto.class, mesa)).from(mesa);

        query.limit(pageable.getPageSize());
        query.offset(pageable.getOffset());

        return new PageImpl<>(query.fetch(), pageable, query.fetchCount());
    }

}
