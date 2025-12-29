package br.com.portalconcurso.service;

import br.com.portalconcurso.config.FileStorageConfig;
import br.com.portalconcurso.infra.exception.FileStorageException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
public class FileStorageService {

    private final Path fileStorageLocation;
    private static final Logger LOGGER = LoggerFactory.getLogger(FileStorageService.class);

    public FileStorageService(FileStorageConfig fileStorageConfig) {
        this.fileStorageLocation = Paths.get(fileStorageConfig.getUploadDir())
                .toAbsolutePath().normalize();

        try {
            LOGGER.info("Creating Directories");
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            LOGGER.error("Could not create the director where files will be stored");
            throw new FileStorageException("Could not create the director where files will be stored", ex.getCause());
        }
    }

    public String storeFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));

        try {
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename Contains a Invalid path Sequence " + fileName);

            }

            LOGGER.info("Save file in Disk");
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (IOException e) {
            LOGGER.error("Could not store file " + fileName + " . Please try Again!");
            throw new FileStorageException("Could not store file " + fileName + ". Please try Again", e);
        }
    }

    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists()){
                return resource;
            } else {
                LOGGER.error("File not found" + fileName);
                throw new FileNotFoundException("File not found " + fileName);            }
        } catch (Exception ex) {
            LOGGER.error("File not found" + fileName);
            throw new FileStorageException("File not found " + fileName, ex);
        }
    }
}
