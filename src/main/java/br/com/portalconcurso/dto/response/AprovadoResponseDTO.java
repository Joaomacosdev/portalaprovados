package br.com.portalconcurso.dto.response;

import org.springframework.web.multipart.MultipartFile;

public record AprovadoResponseDTO(
        Long id,
        String nome,
        String email,
        String telefone,
        String concursos,
        MultipartFile imagem
) {
}
