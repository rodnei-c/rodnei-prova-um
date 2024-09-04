package com.example.rodnei_caetano_prova1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rodnei_caetano_prova1.dto.FuncionarioDto;
import com.example.rodnei_caetano_prova1.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	FuncionarioService funcionarioService;
	
	@PostMapping("/cadastrarFuncionario")
	public FuncionarioDto cadastrarFuncionario(@RequestBody FuncionarioDto funcionario) {
		return funcionarioService.criarFuncionario(funcionario);
	}
	
	
	
}
