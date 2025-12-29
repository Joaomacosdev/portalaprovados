package br.com.portalconcurso.controller.docs;

import br.com.portalconcurso.dto.request.AprovadoRequestDTO;
import br.com.portalconcurso.dto.response.AprovadoResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Tag(name = "Aprovados", description = "Gerenciamento de aprovados")
public interface AprovadoControllerDoc {

    @Operation(summary = "Cadastrar aprovado", description = "Cria um novo aprovado no sistema")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Aprovado criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    ResponseEntity<AprovadoResponseDTO> createAprovado(
            @RequestBody AprovadoRequestDTO dto, UriComponentsBuilder uriComponentsBuilder
    );

    @Operation(summary = "Buscar aprovado por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Aprovado encontrado"),
            @ApiResponse(responseCode = "404", description = "Aprovado não encontrado")
    })
    ResponseEntity<AprovadoResponseDTO> getByIdAprovado(
            @PathVariable Long id
    );

    @Operation(summary = "Listar todos os aprovados")
    @ApiResponse(responseCode = "200", description = "Lista de aprovados")
    ResponseEntity<List<AprovadoResponseDTO>> getAllAprovado();
}
