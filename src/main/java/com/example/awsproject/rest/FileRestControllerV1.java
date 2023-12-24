package com.example.awsproject.rest;

import com.amazonaws.services.s3.model.PutObjectResult;
import com.example.awsproject.model.IFile;
import com.example.awsproject.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

/**
 * Rest Controller for class {@link FileRestControllerV1}.
 *
 * @author Kovtynov Vladimir
 * @version 1.0
 */
@RestController
@RequiredArgsConstructor
public class FileRestControllerV1 {

    private final FileService fileService;

    @PostMapping
    public PutObjectResult upload(@RequestBody IFile file) {
        return this.fileService.upload(file);
    }

    @PutMapping
    public ResponseEntity<?> download(@RequestBody  IFile file) {
        if (StringUtils.hasText(file.getFileName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "File name is missing");
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" +
                file.getFileName());
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        InputStreamResource resource = new InputStreamResource(fileService.downloadFile(file));
        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }
}