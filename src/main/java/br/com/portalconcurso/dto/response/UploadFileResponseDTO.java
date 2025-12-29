package br.com.portalconcurso.dto.response;

public record UploadFileResponseDTO (
         String fileName,
         String fileDownloaderUri,
         String fileType,
         long size
){






}
