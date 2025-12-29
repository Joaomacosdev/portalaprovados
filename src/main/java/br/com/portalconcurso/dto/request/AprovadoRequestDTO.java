package br.com.portalconcurso.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record AprovadoRequestDTO(
        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
        String nome,

        @NotBlank(message = "O e-mail é obrigatório")
        @Email(message = "E-mail inválido")
        String email,

        @NotBlank(message = "O telefone é obrigatório")
        @Pattern(
                regexp = "\\(?\\d{2}\\)?\\s?9?\\d{4}-?\\d{4}",
                message = "Telefone inválido. Ex: (11) 91234-5678"
        )
        String telefone,

        @NotBlank(message = "O concurso é obrigatório")
        @Size(min = 3, max = 100, message = "O concurso deve ter entre 3 e 100 caracteres")
        String concursos,

      //  @Size(max = 255, message = "O caminho da imagem deve ter no máximo 255 caracteres")
        String imagemPath
) {
}
