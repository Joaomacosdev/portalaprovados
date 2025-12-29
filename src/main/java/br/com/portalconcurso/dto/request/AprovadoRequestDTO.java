package br.com.portalconcurso.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public record AprovadoRequestDTO(
        @NotBlank
        String nome,
        @NotBlank
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        String concursos,
        MultipartFile imagem
) {
}
