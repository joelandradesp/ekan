package br.com.joelandrade.avaliacaoekan.dtos;

import java.util.List;

import br.com.joelandrade.avaliacaoekan.domain.Documento;

public class BeneficiarioComDocumentosDTO {
	private Long id;
	private String nome;
	private List<Documento> documentos;
	
	public BeneficiarioComDocumentosDTO(Long id, String nome, List<Documento> documentos) {
		// TODO Auto-generated constructor stub
	}
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
	public List<Documento> getDocumentos() {
		return documentos;
	}
	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}
}