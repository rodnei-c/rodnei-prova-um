package com.example.rodnei_caetano_prova1.repository.impl;

import com.example.rodnei_caetano_prova1.dto.ReservaDto;
import com.example.rodnei_caetano_prova1.entity.QClienteEntity;
import com.example.rodnei_caetano_prova1.entity.QPedidoEntity;
import com.example.rodnei_caetano_prova1.entity.QReservaEntity;
import com.example.rodnei_caetano_prova1.entity.QRestauranteEntity;
import com.example.rodnei_caetano_prova1.repository.ReservaRepositoryCustom;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class ReservaRepositoryImpl implements ReservaRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    final QReservaEntity reserva = QReservaEntity.reservaEntity;
    final QPedidoEntity pedido = QPedidoEntity.pedidoEntity;
    final QRestauranteEntity restaurante = QRestauranteEntity.restauranteEntity;
    final QClienteEntity cliente = QClienteEntity.clienteEntity;

    @Override
    public Page<ReservaDto> buscaObservacao(Pageable pageable, String searchTerm, Long idRestaurante, String descricao) {
        var query = new JPAQuery<ReservaDto>(em);

        query.select(Projections.constructor(ReservaDto.class, reserva))
                .from(reserva)
                .join(reserva.cliente_id, cliente)
                .join(cliente.restaurante_id, restaurante)
                .where(restaurante.id.eq(idRestaurante).and(reserva.observacao.containsIgnoreCase(descricao)));

        query.limit(pageable.getPageSize());
        query.offset(pageable.getOffset());

        return new PageImpl<>(query.fetch(), pageable, query.fetchCount());
    }
}
