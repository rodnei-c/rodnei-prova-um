package com.example.rodnei_caetano_prova1.repository;

import com.example.rodnei_caetano_prova1.dto.ReservaDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReservaRepositoryCustom {

    Page<ReservaDto> buscaObservacao(Pageable pageable, String searchTerm, Long idRestaurante, String descricao);

}
