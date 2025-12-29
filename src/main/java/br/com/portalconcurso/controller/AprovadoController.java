package br.com.portalconcurso.controller;

import br.com.portalconcurso.dto.request.AprovadoRequestDTO;
import br.com.portalconcurso.dto.response.AprovadoResponseDTO;
import br.com.portalconcurso.service.AprovadoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<AprovadoResponseDTO> getByIdAprovado(@PathVariable Long id){
        return ResponseEntity.ok().body(aprovadoService.getByIdAprovado(id));
    }

    @GetMapping
    public ResponseEntity<List<AprovadoResponseDTO>> getAllAprovado(){
        return ResponseEntity.ok().body(aprovadoService.getAllAprovados());
    }
}
