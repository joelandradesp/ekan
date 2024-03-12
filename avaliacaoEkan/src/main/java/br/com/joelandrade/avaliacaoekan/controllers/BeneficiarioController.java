package br.com.joelandrade.avaliacaoekan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joelandrade.avaliacaoekan.domain.Beneficiario;
import br.com.joelandrade.avaliacaoekan.dto.BeneficiarioDTO;
import br.com.joelandrade.avaliacaoekan.services.BeneficiarioService;

@RestController
@RequestMapping("/api/beneficiarios")
public class BeneficiarioController {
	
	@Autowired
	private BeneficiarioService beneficiarioService;
	
    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarBeneficiarioComDocumentos(@RequestBody BeneficiarioDTO beneficiarioDTO) {
        Beneficiario beneficiario = beneficiarioDTO.toBeneficiario();
        beneficiarioService.cadastrarBeneficiarioComDocumentos(beneficiario);
        return ResponseEntity.ok("Beneficiário cadastrado com sucesso");
    }
}