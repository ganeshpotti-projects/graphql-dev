package com.learning.graphql_playground.sec01.lec05.controllers;

import com.learning.graphql_playground.sec01.lec05.entities.Customer;
import com.learning.graphql_playground.sec01.lec05.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @SchemaMapping(
            typeName = "Query"
    )
    public Flux<Customer> customers(){
        return customerService.allCustomers();
    }
}
