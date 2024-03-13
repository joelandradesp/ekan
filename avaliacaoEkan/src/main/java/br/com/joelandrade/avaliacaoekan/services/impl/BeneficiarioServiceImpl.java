package br.com.joelandrade.avaliacaoekan.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.joelandrade.avaliacaoekan.Repository.BeneficiarioRepository;
import br.com.joelandrade.avaliacaoekan.Repository.DocumentoRepository;
import br.com.joelandrade.avaliacaoekan.domain.Beneficiario;
import br.com.joelandrade.avaliacaoekan.domain.Documento;
import br.com.joelandrade.avaliacaoekan.dtos.BeneficiarioComDocumentosDTO;
import br.com.joelandrade.avaliacaoekan.services.BeneficiarioService;

@Service
public class BeneficiarioServiceImpl implements BeneficiarioService {

	@Autowired
	private BeneficiarioRepository beneficiarioRepository;

	@Autowired
	private DocumentoRepository documentoRepository;

	@Override
	public List<Beneficiario> listarTodos() {
		return beneficiarioRepository.findAll();
	}

	public Beneficiario salvarBeneficiario(Beneficiario beneficiario) {
		return beneficiarioRepository.save(beneficiario);
	}

	public void cadastrarBeneficiarioComDocumentos(Beneficiario beneficiario) {
		Beneficiario beneficiarioSalvo = beneficiarioRepository.save(beneficiario);
		for (Documento documento : beneficiario.getDocumentos()) {
			documento.setBeneficiario(beneficiarioSalvo);
		}

		documentoRepository.saveAllAndFlush(beneficiario.getDocumentos());

	}

	public Beneficiario buscarBeneficiarioPorId(Long id) {
		return beneficiarioRepository.findById(id).orElse(null);
	}

	@Override
	public List<Beneficiario> listarBeneficiarios() {
		return beneficiarioRepository.findAll();
	}

	@Override
	public List<Documento> listarDocumentosPorBeneficiario(Long beneficiarioId) {
		Beneficiario beneficiario = beneficiarioRepository.findById(beneficiarioId).orElse(null);
		if (beneficiario != null) {
			return beneficiario.getDocumentos();
		}
		return null;
	}

	@Override
	public Beneficiario atualizarBeneficiario(Long beneficiarioId, Beneficiario novoBeneficiario) {
		Optional<Beneficiario> beneficiarioOptional = beneficiarioRepository.findById(beneficiarioId);
		if (beneficiarioOptional.isPresent()) {
			Beneficiario beneficiario = beneficiarioOptional.get();
			beneficiario.setNome(novoBeneficiario.getNome());
			beneficiario.setTelefone(novoBeneficiario.getTelefone());
			beneficiario.setDataNascimento(novoBeneficiario.getDataNascimento());
			beneficiario.setDataAtualizacao(new Date()); // Atualiza a data de atualização
			return beneficiarioRepository.save(beneficiario);
		}
		return null;
	}

	@Override
	@Transactional
	public void removerBeneficiario(Long beneficiarioId) {
		Optional<Beneficiario> beneficiarioOptional = beneficiarioRepository.findById(beneficiarioId);
		if (beneficiarioOptional.isPresent()) {
			Beneficiario beneficiario = beneficiarioOptional.get();
	        List<Documento> documentos = beneficiario.getDocumentos();
	        // Deleta os documentos associados ao beneficiário
	        documentoRepository.deleteAll(documentos);
	        // Deleta o beneficiário
	        beneficiarioRepository.delete(beneficiario);
		}
	}

	@Override
	 public List<BeneficiarioComDocumentosDTO> listarBeneficiariosComDocumentos() {
        List<Beneficiario> beneficiarios = beneficiarioRepository.findAll();
        return beneficiarios.stream()
                .map(beneficiario -> new BeneficiarioComDocumentosDTO(
                		 beneficiario.getId(),
                         beneficiario.getNome(),
                         beneficiario.getDocumentos()
                ))
                .collect(Collectors.toList());
    }
}
