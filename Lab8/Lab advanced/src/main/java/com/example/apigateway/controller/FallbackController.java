package com.example.apigateway.controller;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.*;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping("/books")
    public Mono<Map<String, String>> bookFallback() {
        return Mono.just(Map.of("status","error","message","Book Service unavailable"));
    }

    @GetMapping("/users")
    public Mono<Map<String, String>> userFallback() {
        return Mono.just(Map.of("status","error","message","User Service unavailable"));
    }
}
