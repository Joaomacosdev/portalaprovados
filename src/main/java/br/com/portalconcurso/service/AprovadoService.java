package br.com.portalconcurso.service;

import br.com.portalconcurso.repository.AprovadoRepository;
import org.springframework.stereotype.Service;

@Service
public class AprovadoService {

    private final AprovadoRepository aprovadoRepository;

    public AprovadoService(AprovadoRepository aprovadoRepository) {
        this.aprovadoRepository = aprovadoRepository;
    }
}
