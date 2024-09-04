package com.example.rodnei_caetano_prova1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rodnei_caetano_prova1.entity.MesaEntity;

@Repository
public interface MesaRepository extends JpaRepository<MesaEntity, Long> {

}
