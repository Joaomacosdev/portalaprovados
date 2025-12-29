package br.com.portalconcurso.dto.response;

import java.io.Serial;
import java.io.Serializable;

public class UploadFileResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String fileName;
    private String fileDownloaderUri;
    private String fileType;
    private long size;

    public UploadFileResponseDTO(String fileName, String fileDownloadUri, String contentType, long size) {
    }
}
