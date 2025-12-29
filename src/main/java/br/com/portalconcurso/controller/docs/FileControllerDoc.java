package br.com.portalconcurso.controller.docs;

import br.com.portalconcurso.dto.response.UploadFileResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Tag(name = "Files", description = "Gerenciamento de aprovados")
public interface FileControllerDoc {
    @Operation(
            summary = "Upload de arquivo",
            description = "Realiza o upload de um único arquivo"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Arquivo enviado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao enviar arquivo")
    })
    ResponseEntity<UploadFileResponseDTO> uploadFile(
            @Parameter(description = "Arquivo a ser enviado", required = true)
            @RequestParam("file") MultipartFile file
    );

    @Operation(
            summary = "Upload de múltiplos arquivos",
            description = "Realiza o upload de vários arquivos de uma só vez"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Arquivos enviados com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao enviar arquivos")
    })
    ResponseEntity<List<ResponseEntity<UploadFileResponseDTO>>> uploadMultipleFiles(
            @Parameter(description = "Lista de arquivos", required = true)
            @RequestParam("files") MultipartFile[] files
    );

    @Operation(
            summary = "Download de arquivo",
            description = "Faz o download de um arquivo pelo nome"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Arquivo baixado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Arquivo não encontrado")
    })
    ResponseEntity<Resource> downloadFile(
            @Parameter(description = "Nome do arquivo", example = "documento.pdf")
            @PathVariable String fileName, HttpServletRequest request
    );
}
