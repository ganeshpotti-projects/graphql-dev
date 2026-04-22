package com.learning.graphql_playground.lec02.controllers;

import com.learning.graphql_playground.lec02.dto.AgeRangeFilter;
import com.learning.graphql_playground.lec02.entities.Customer;
import com.learning.graphql_playground.lec02.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @QueryMapping("customers")
    public Flux<Customer> allCustomers(){
        return customerService.allCustomers();
    }

    @QueryMapping("customerById")
    public Mono<Customer> customerById(@Argument("id") Integer value){
        return customerService.customerById(value);
    }

    @QueryMapping("customersByName")
    public Flux<Customer> customersByName(@Argument("name") String value){
        return customerService.customersByName(value);
    }

    @QueryMapping("customersBetweenAge")
    public Flux<Customer> customersBetweenAge(@Argument("filter")AgeRangeFilter ageRangeFilter){
        return customerService.customersBetweenAge(ageRangeFilter);
    }
}
