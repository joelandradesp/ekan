package br.com.joelandrade.avaliacaoekan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.joelandrade.avaliacaoekan.domain.Documento;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {

}