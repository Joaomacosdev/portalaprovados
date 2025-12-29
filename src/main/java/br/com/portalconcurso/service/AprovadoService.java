package br.com.portalconcurso.service;

import br.com.portalconcurso.dto.request.AprovadoRequestDTO;
import br.com.portalconcurso.dto.response.AprovadoResponseDTO;
import br.com.portalconcurso.model.Aprovado;
import br.com.portalconcurso.repository.AprovadoRepository;
import br.com.portalconcurso.service.validator.aprovado.ValidatorAprovado;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AprovadoService {

    private final AprovadoRepository aprovadoRepository;
    private final List<ValidatorAprovado> validators;

    public AprovadoService(AprovadoRepository aprovadoRepository, List<ValidatorAprovado> validators) {
        this.aprovadoRepository = aprovadoRepository;
        this.validators = validators;
    }

    public AprovadoResponseDTO createAprovado(AprovadoRequestDTO dto) {
        validators.forEach(v -> v.validate(dto));

        Aprovado aprovado = new Aprovado(dto);
        aprovadoRepository.save(aprovado);

        return new AprovadoResponseDTO(aprovado);
    }
}
