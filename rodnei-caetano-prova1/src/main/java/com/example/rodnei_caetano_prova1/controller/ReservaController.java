package com.example.rodnei_caetano_prova1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rodnei_caetano_prova1.dto.ReservaDto;
import com.example.rodnei_caetano_prova1.service.ReservaService;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

	@Autowired
	ReservaService reservaService;

	@GetMapping("/buscarReservas")
	public List<ReservaDto> buscarReservas() {
		return reservaService.buscarReservas();
	}

	@PostMapping("cadastrarReserva")
	public ResponseEntity<?> cadastrarReserva(@RequestBody ReservaDto criaReserva) {
		try {
			return ResponseEntity.ok(reservaService.cadastrarReserva(criaReserva));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping("/buscarPorCliente/{cliente}")
	public List<ReservaDto> buscaPorCliente(@PathVariable Long cliente) {
		return reservaService.findByClient(cliente);
	}

	@GetMapping("/verificarDisponibilidade/{numeroMesa}")
	public String verificarDisponibilidade(@PathVariable("numeroMesa") Integer mesa) {
		return reservaService.verifyTable(mesa);
	}

	@PutMapping("/alterarStatus/{id}")
	public ResponseEntity<?> alterarStatus(@PathVariable("id") Long id, @RequestBody ReservaDto reserva) throws Exception {
		try {
		return ResponseEntity.ok(reservaService.updateStatus(id, reserva.getStatus()));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
