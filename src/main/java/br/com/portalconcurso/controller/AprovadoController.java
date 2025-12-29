package br.com.portalconcurso.controller;

import br.com.portalconcurso.dto.request.AprovadoRequestDTO;
import br.com.portalconcurso.dto.response.AprovadoResponseDTO;
import br.com.portalconcurso.service.AprovadoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/aprovado")
public class AprovadoController {

    private final AprovadoService aprovadoService;

    public AprovadoController(AprovadoService aprovadoService) {
        this.aprovadoService = aprovadoService;
    }

    @PostMapping
    public ResponseEntity<AprovadoResponseDTO> createAprovado(@Valid @RequestBody AprovadoRequestDTO dto, UriComponentsBuilder uriBuilder) {
        AprovadoResponseDTO aprovado = aprovadoService.createAprovado(dto);
        URI uri = uriBuilder.path("api/v1/aprovado/{id}").buildAndExpand(aprovado.id()).toUri();
        return ResponseEntity.created(uri).body(aprovado);

    }
}
