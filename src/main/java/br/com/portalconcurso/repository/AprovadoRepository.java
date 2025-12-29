package br.com.portalconcurso.repository;

import br.com.portalconcurso.model.Aprovado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AprovadoRepository extends JpaRepository<Aprovado, Long> {
}
