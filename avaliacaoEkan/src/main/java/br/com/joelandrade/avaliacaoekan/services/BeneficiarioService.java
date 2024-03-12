package br.com.joelandrade.avaliacaoekan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.joelandrade.avaliacaoekan.Repository.BeneficiarioRepository;
import br.com.joelandrade.avaliacaoekan.domain.Beneficiario;

@Service
public class BeneficiarioService {
	
	@Autowired
	private BeneficiarioRepository beneficiarioRepository;
	
	public void cadastrarBeneficiarioComDocumentos(Beneficiario beneficiario) {
		beneficiarioRepository.save(beneficiario);
	}

}
