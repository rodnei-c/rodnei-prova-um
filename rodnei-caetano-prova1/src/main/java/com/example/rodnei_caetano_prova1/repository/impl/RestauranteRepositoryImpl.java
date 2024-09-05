package com.example.rodnei_caetano_prova1.repository.impl;

import com.example.rodnei_caetano_prova1.dto.RestauranteDto;
import com.example.rodnei_caetano_prova1.entity.QRestauranteEntity;
import com.example.rodnei_caetano_prova1.entity.RestauranteEntity;
import com.example.rodnei_caetano_prova1.repository.RestauranteRepositoryCustom;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class RestauranteRepositoryImpl implements RestauranteRepositoryCustom {

    @PersistenceContext
    private EntityManager em;
    final QRestauranteEntity restaurante = QRestauranteEntity.restauranteEntity;

    @Override
    public Page<RestauranteDto> buscaRestaurantes(Pageable pageable, String searchTerm) {

        JPAQuery<RestauranteDto> query = new JPAQuery<>(em);

        query.select(Projections.constructor(RestauranteDto.class, restaurante)).from(restaurante);

        query.limit(pageable.getPageSize());
        query.offset(pageable.getOffset());

        return new PageImpl<>(query.fetch(), pageable, query.fetchCount());
    }
}
