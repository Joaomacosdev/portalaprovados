package br.com.portalconcurso.controller;

import br.com.portalconcurso.controller.docs.AprovadoControllerDoc;
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
public class AprovadoController implements AprovadoControllerDoc {

    private final AprovadoService aprovadoService;

    public AprovadoController(AprovadoService aprovadoService) {
        this.aprovadoService = aprovadoService;
    }

    @PostMapping
    @Override
    public ResponseEntity<AprovadoResponseDTO> createAprovado(@Valid @RequestBody AprovadoRequestDTO dto, UriComponentsBuilder uriBuilder) {
        AprovadoResponseDTO aprovado = aprovadoService.createAprovado(dto);
        return ResponseEntity
                .created(URI.create("/api/v1/aprovado/" + aprovado.id()))
                .body(aprovado);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<AprovadoResponseDTO> getByIdAprovado(@PathVariable Long id){
        return ResponseEntity.ok().body(aprovadoService.getByIdAprovado(id));
    }

    @GetMapping
    @Override
    public ResponseEntity<List<AprovadoResponseDTO>> getAllAprovado(){
        return ResponseEntity.ok().body(aprovadoService.getAllAprovados());
    }
}
