package com.example.rodnei_caetano_prova1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.example.rodnei_caetano_prova1.dto.MesaDto;
import com.example.rodnei_caetano_prova1.service.MesaService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/mesas")
public class MesaController {

	@Autowired
	MesaService mesaService;
	
	@PostMapping("/cadastrarMesa")
	public MesaDto criarMesa(@RequestBody MesaDto mesa) {
		return mesaService.criarMesa(mesa);
	}

	@GetMapping
	public List<MesaDto> listarMesas(@RequestParam(defaultValue = "0", required = false) Integer page,
									 @RequestParam(defaultValue = "10", required = false) Integer size,
									 @RequestParam(required = false) String searchTerm){
		return mesaService.listarMesas(Pageable.ofSize(size).withPage(page), searchTerm);
	}

	@GetMapping("/mesas-disponiveis")
	public List<MesaDto> listarMesasDisponiveis(@RequestParam(defaultValue = "0", required = false) Integer page,
												@RequestParam(defaultValue = "10", required = false) Integer size,
												@RequestParam(required = false) String searchTerm,
												@RequestParam LocalDate data,
												@RequestParam Integer quant_pessoas){
		return mesaService.listarMesasDisponiveis(Pageable.ofSize(size).withPage(page), searchTerm, data, quant_pessoas);
	}
	
}
