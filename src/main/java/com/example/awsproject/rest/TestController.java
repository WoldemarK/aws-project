package com.example.awsproject.rest;

import com.example.awsproject.model.IFile;
import com.example.awsproject.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/test")
public class TestController {

    @GetMapping
    public Mono<String> getTestingMessage() {
        return Mono.just("Testing Message");
    }

}
