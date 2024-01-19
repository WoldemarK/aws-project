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
 * Rest Controller for interface {@link FileRestControllerV1}.
 *
 * @author Kovtynov Vladimir
 * @version 1.0
 */

public interface FileRestControllerV1 {
    ResponseEntity<PutObjectResult> upload(IFile file);
    ResponseEntity<?> download(IFile file);
}