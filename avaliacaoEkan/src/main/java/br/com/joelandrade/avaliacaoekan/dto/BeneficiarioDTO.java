package br.com.joelandrade.avaliacaoekan.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.joelandrade.avaliacaoekan.domain.Beneficiario;
import br.com.joelandrade.avaliacaoekan.domain.Documento;

public class BeneficiarioDTO {
	private Long id;
	private String nome;
	private List<DocumentoDTO> documentos;

	// getters e setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<DocumentoDTO> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<DocumentoDTO> documentos) {
		this.documentos = documentos;
	}

	public Beneficiario toBeneficiario() {
		Beneficiario beneficiario = new Beneficiario();
		beneficiario.setId(this.id);
		beneficiario.setNome(this.nome);

		if (this.documentos != null) {
			List<Documento> documentos = this.documentos.stream().map(DocumentoDTO::toDocumento)
					.collect(Collectors.toList());
			beneficiario.setDocumentos(documentos);
		}

		return beneficiario;
	}
}
