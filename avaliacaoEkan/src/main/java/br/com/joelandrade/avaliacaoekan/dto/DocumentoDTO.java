package br.com.joelandrade.avaliacaoekan.dto;

import java.util.Date;
import br.com.joelandrade.avaliacaoekan.domain.Documento;

public class DocumentoDTO {

	private Long id;
	private String tipoDocumento;
	private String descricao;
	private Date dataInclusao;
	private Date dataAtualizacao;

	// getters e setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Documento toDocumento() {
		Documento documento = new Documento();
		documento.setId(this.id);
		documento.setTipoDocumento(this.tipoDocumento);
		documento.setDescricao(this.descricao);
		documento.setDataInclusao(this.dataInclusao);
		documento.setDataAtualizacao(this.dataAtualizacao);
		return documento;
	}
}
