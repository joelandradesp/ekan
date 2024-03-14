package br.com.joelandrade.avaliacaoekan.domain;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Beneficiario {
	@Id
	@GeneratedValue(generator = "beneficiario_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "beneficiario_seq", sequenceName = "beneficiario_sequence", initialValue = 1,allocationSize = 1)
	private Long id;
    private String nome;
	private String telefone;
    @Temporal(TemporalType.DATE)
	private Date dataNascimento;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

    @OneToMany(mappedBy = "beneficiario", fetch = FetchType.EAGER)
    private List<Documento> documentos;
    
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
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

	public List<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}
	
	
	public Beneficiario toBeneficiario() {
		Beneficiario beneficiario = new Beneficiario();
		beneficiario.setNome(this.nome);
		beneficiario.setTelefone(this.telefone);
		beneficiario.setDataNascimento(dataNascimento);
		beneficiario.setDataInclusao(dataInclusao);
		beneficiario.setDataAtualizacao(dataAtualizacao);

		if (this.documentos != null) {
			List<Documento> documentos = this.documentos.stream().map(Documento::toDocumento)
					.collect(Collectors.toList());
			beneficiario.setDocumentos(documentos);
		}

		return beneficiario;
	}
}