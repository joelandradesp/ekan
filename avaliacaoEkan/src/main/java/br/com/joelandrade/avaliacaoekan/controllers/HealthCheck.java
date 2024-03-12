package br.com.joelandrade.avaliacaoekan.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/health")
public class HealthCheck {
	@GetMapping("/ready")
	public ResponseEntity<String> getReady() {
		return ResponseEntity.ok("OK");
	}

	@GetMapping("/live")
	public ResponseEntity<String> getLive() {
		return ResponseEntity.ok("OK");
	}
}
