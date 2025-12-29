package br.com.portalconcurso.dto.response;

import br.com.portalconcurso.model.Aprovado;
import org.springframework.web.multipart.MultipartFile;

public record AprovadoResponseDTO(
        Long id,
        String nome,
        String email,
        String telefone,
        String concursos,
        String imagemPath
) {
    public AprovadoResponseDTO(Aprovado aprovado) {
        this(aprovado.getId(), aprovado.getNome(), aprovado.getEmail(), aprovado.getTelefone(), aprovado.getConcursos(), aprovado.getImagemPath());
    }
}
