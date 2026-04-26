package com.learning.graphql_playground.lec10.controller;

import com.learning.graphql_playground.lec10.dto.Book;
import com.learning.graphql_playground.lec10.dto.Brand;
import com.learning.graphql_playground.lec10.dto.Electronic;
import com.learning.graphql_playground.lec10.dto.Fruit;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Controller
public class ProductController {
    @QueryMapping
    public Flux<Object> products(){
        return Flux.just(
                Fruit.create(UUID.randomUUID(), "banana", 1, "2026-04-08"),
                Electronic.create(UUID.randomUUID(), "macbook", 250, Brand.APPLE),
                Book.create(UUID.randomUUID(), "nestle", 100,"ganesh")
        );
    }
}
