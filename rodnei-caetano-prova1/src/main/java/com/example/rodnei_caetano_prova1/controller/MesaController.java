package com.example.rodnei_caetano_prova1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rodnei_caetano_prova1.dto.MesaDto;
import com.example.rodnei_caetano_prova1.service.MesaService;

@RestController
@RequestMapping("/mesas")
public class MesaController {

	@Autowired
	MesaService mesaService;
	
	@PostMapping("/cadastrarMesa")
	public MesaDto criarMesa(@RequestBody MesaDto mesa) {
		return mesaService.criarMesa(mesa);
	}
	
}
