package br.com.joelandrade.avaliacaoekan.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@CrossOrigin
@RequestMapping("/health")
public class HealthCheck {
	@GetMapping("/ready")
	@Operation(summary = "HealthCheck para verificar se a aplicação esta no ar.")
	public ResponseEntity<String> getReady() {
		return ResponseEntity.ok("OK");
	}

	@GetMapping("/live")
	@Operation(summary = "HealthCheck para verificar se a aplicação esta no ar - Pode ser usada para checar algo a mais, como Banco de Dados esta Ativo.")
	public ResponseEntity<String> getLive() {
		return ResponseEntity.ok("OK");
	}
}
