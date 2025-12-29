package br.com.portalconcurso.controller;


import br.com.portalconcurso.dto.response.UploadFileResponseDTO;
import br.com.portalconcurso.service.FileStorageService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/file/v1")
public class FileController {

    private final FileStorageService fileStorageService;
    private static final Logger LOGGER = LoggerFactory.getLogger(FileController.class);

    public FileController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @PostMapping("/uploadFile")
    public ResponseEntity<UploadFileResponseDTO> uploadFile(@RequestParam("file") MultipartFile file) {
        var fileName = fileStorageService.storeFile(file);
        var fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/file/v1/downloadFile")
                .path(fileName)
                .toUriString();
        return ResponseEntity.ok().body(new UploadFileResponseDTO(fileName, fileDownloadUri, file.getContentType(), file.getSize()));
    }

    @PostMapping("/uploadMultipleFiles")
    public ResponseEntity<List<ResponseEntity<UploadFileResponseDTO>>> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return ResponseEntity.ok().body(Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList()));
    }

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        Resource resource = fileStorageService.loadFileAsResource(fileName);
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (Exception ex){
            LOGGER.error("Could ot determine file type!");
        }

        if (contentType == null){
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
