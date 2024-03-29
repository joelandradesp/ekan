package br.com.joelandrade.avaliacaoekan.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Documento {
	@Id
	@GeneratedValue(generator = "documento_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "documento_seq", sequenceName = "documento_sequence", initialValue = 1, allocationSize = 1)

	private Long id;
	private String tipoDocumento;
	private String descricao;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInclusao;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAtualizacao;

	@ManyToOne
	@JoinColumn(name = "beneficiario_id", nullable = false)
	@JsonIgnore
	private Beneficiario beneficiario;

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

	public Beneficiario getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(Beneficiario beneficiario) {
		this.beneficiario = beneficiario;
	}

	public Documento toDocumento() {
		Documento documento = new Documento();
		documento.setTipoDocumento(this.tipoDocumento);
		documento.setDescricao(this.descricao);
		documento.setDataInclusao(this.dataInclusao);
		documento.setDataAtualizacao(this.dataAtualizacao);
		return documento;
	}
}