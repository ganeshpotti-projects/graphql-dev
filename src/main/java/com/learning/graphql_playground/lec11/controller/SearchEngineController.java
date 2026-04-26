package com.learning.graphql_playground.lec11.controller;

import com.learning.graphql_playground.lec11.dto.Book;
import com.learning.graphql_playground.lec11.dto.Brand;
import com.learning.graphql_playground.lec11.dto.Electronic;
import com.learning.graphql_playground.lec11.dto.FruitDto;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;

@Controller
public class SearchEngineController {

    List<Object> list = List.of(
            FruitDto.create( "banana",  "2026-04-08"),
            Electronic.create(UUID.randomUUID(), "macbook", 250, Brand.APPLE),
            Book.create("nestle", "ganesh")
    );

    @QueryMapping
    public Flux<Object> search(){
        return Mono.fromSupplier(() -> new ArrayList<>(list))
                .doOnNext(Collections::shuffle)
                .flatMapIterable(Function.identity())
                .take(ThreadLocalRandom.current().nextInt(list.size()));
    }
}
