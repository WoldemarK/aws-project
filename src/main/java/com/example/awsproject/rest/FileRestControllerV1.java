package com.example.awsproject.rest;

import com.example.awsproject.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FileRestControllerV1 {

    private final FileService fileService;
}
