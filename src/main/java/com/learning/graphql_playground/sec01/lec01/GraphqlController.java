package com.learning.graphql_playground.sec01.lec01;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.concurrent.ThreadLocalRandom;

@Controller
public class GraphqlController {

    @QueryMapping("sayHello")
    public Mono<String> helloWorld(){
        return Mono.just( "Hello World");
    }

    @QueryMapping("sayHello2")
    public Mono<String> sayHello2(@Argument("name") String value){
        return Mono.fromSupplier(() -> "Hello, Your Name is: "+value);
    }

    @QueryMapping("random")
    public Mono<Integer> random(){
        return Mono.just(ThreadLocalRandom.current().nextInt(1,1000));
    }
}
