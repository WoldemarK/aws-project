package com.example.awsproject.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping
    public Mono<String> getTestingMessage() {
        return Mono.just("Testing Message");
    }
}
