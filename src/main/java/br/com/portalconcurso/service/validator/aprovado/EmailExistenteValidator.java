package br.com.portalconcurso.service.validator.aprovado;

import br.com.portalconcurso.dto.request.AprovadoRequestDTO;
import br.com.portalconcurso.infra.exception.BusinessException;
import br.com.portalconcurso.repository.AprovadoRepository;
import org.springframework.stereotype.Component;

@Component
public class EmailExistenteValidator implements ValidatorAprovado {

    private final AprovadoRepository aprovadoRepository;

    public EmailExistenteValidator(AprovadoRepository aprovadoRepository) {
        this.aprovadoRepository = aprovadoRepository;
    }

    @Override
    public void validate(AprovadoRequestDTO dto) {
        if (aprovadoRepository.existsByEmail(dto.email())) {
            throw new BusinessException("Já existe um aprovado cadastrado com este e-mail.");
        }
    }
}
