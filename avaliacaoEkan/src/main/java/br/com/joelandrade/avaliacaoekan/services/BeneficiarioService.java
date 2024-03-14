package br.com.joelandrade.avaliacaoekan.services;

import java.util.List;
import br.com.joelandrade.avaliacaoekan.domain.Beneficiario;
import br.com.joelandrade.avaliacaoekan.domain.Documento;

public interface BeneficiarioService {
	
	List<Beneficiario> listarTodos();
    List<Beneficiario> listarBeneficiarios();
    List<Documento> listarDocumentosPorBeneficiario(Long beneficiarioId);
    Beneficiario atualizarBeneficiario(Long beneficiarioId, Beneficiario novoBeneficiario);
    void removerBeneficiario(Long beneficiarioId);

}
