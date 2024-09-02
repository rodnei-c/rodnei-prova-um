package com.example.rodnei_caetano_prova1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.rodnei_caetano_prova1.entity.ReservaEntity;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity, Long>{

//	@Query("SELECT reserva.data_reserva FROM reserva")
//	List<ReservaEntity> listaDatas();
	
}
