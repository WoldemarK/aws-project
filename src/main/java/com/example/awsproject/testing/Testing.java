package com.example.awsproject.testing;

import reactor.core.publisher.Flux;

public class Testing {
    public static void main(String[] args) {
        Flux<String>stringFlux = Flux.just("sss","ddd","wwww");
        stringFlux.subscribe(System.out::println);
        stringFlux.log().subscribe(System.out::println);
    }
}
