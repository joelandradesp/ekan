package br.com.joelandrade.avaliacaoekan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.joelandrade.avaliacaoekan.domain.Beneficiario;
import br.com.joelandrade.avaliacaoekan.domain.Documento;
import br.com.joelandrade.avaliacaoekan.services.impl.BeneficiarioServiceImpl;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(path = "/api/beneficiarios")
@CrossOrigin
public class BeneficiarioController {

	@Autowired
	private BeneficiarioServiceImpl beneficiarioService;

	@PostMapping(path = "/cadastrar")
	@Operation(summary = "Cadastrar um beneficiário junto com seus documentos")
	public ResponseEntity<String> cadastrarBeneficiarioComDocumentos(@RequestBody Beneficiario beneficiario) {
		Beneficiario beneficiariocadastrar = beneficiario.toBeneficiario();
		beneficiarioService.cadastrarBeneficiarioComDocumentos(beneficiariocadastrar);
		return ResponseEntity.ok("Beneficiário cadastrado com sucesso");
	}

	@GetMapping
	@Operation(summary = "Listar todos os Beneficiários e todos os documentos")
	public ResponseEntity<List<Beneficiario>> listarTodos() {
		return ResponseEntity.ok(beneficiarioService.listarTodos());
	}

	@GetMapping(path = "/beneficiarios")
	@Operation(summary = "Listar Beneficiários")
	public List<Beneficiario> listarBeneficiarios() {
		return beneficiarioService.listarBeneficiarios();
	}

	@GetMapping(path = "/{beneficiarioId}/documentos")
	@Operation(summary = "Listar somente os Documentos filtrado por id do beneficiário")
	public List<Documento> listarDocumentosPorBeneficiario(@PathVariable Long beneficiarioId) {
		return beneficiarioService.listarDocumentosPorBeneficiario(beneficiarioId);
	}

	@GetMapping(path = "/{id}")
	@Operation(summary = "Listar todos os documentos de um beneficiário a partir de seu id")
	public Beneficiario getBeneficiario(@PathVariable Long id) {
		return beneficiarioService.buscarBeneficiarioPorId(id);
	}

	@PutMapping(path = "/{beneficiarioId}")
	@Operation(summary = "Atualizar os dados cadastrais de um beneficiário")
	public Beneficiario atualizarBeneficiario(@PathVariable Long beneficiarioId,
			@RequestBody Beneficiario novoBeneficiario) {
		return beneficiarioService.atualizarBeneficiario(beneficiarioId, novoBeneficiario);
	}

	@DeleteMapping(path = "/{beneficiarioId}")
	@Operation(summary = "Remover um beneficiário junto com seus documentos")
	public void removerBeneficiario(@PathVariable(name = "beneficiarioId") Long beneficiarioId) {
		beneficiarioService.removerBeneficiario(beneficiarioId);
	}

}