package com.example.rodnei_caetano_prova1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.example.rodnei_caetano_prova1.dto.RestauranteDto;
import com.example.rodnei_caetano_prova1.service.RestauranteService;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

	@Autowired
	RestauranteService restauranteService;
	
	@PostMapping("/cadastrarRestaurante")
	public RestauranteDto criarRestaurante(@RequestBody RestauranteDto restaurante) {
		return restauranteService.criarRestaurante(restaurante);
	}

	@GetMapping
	public List<RestauranteDto> listarRestaurantes(@RequestParam(defaultValue = "0", required = false) Integer page,
												   @RequestParam(defaultValue = "10", required = false) Integer size,
												   @RequestParam(required = false) String searchTerm) {
		return restauranteService.listarRestaurantes(Pageable.ofSize(size).withPage(page), searchTerm);
	}
}
