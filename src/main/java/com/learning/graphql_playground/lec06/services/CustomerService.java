package com.learning.graphql_playground.lec06.services;

import com.learning.graphql_playground.lec06.entities.Customer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

@Service
public class CustomerService {
    private final Flux<Customer> flux = Flux.just(
            Customer.create(1, "sam", 22, "pune"),
            Customer.create(2, "john", 26, "guntur"),
            Customer.create(3, "jolly", 25, "hyderabad"),
            Customer.create(4, "belly", 23, "delhi")
    );

    public Flux<Customer> allCustomers(){
        return flux.doOnNext(c -> print("customer "+ c.getName()));
    }

    private void print(String msg){
        System.out.println(LocalDateTime.now() +" "+ msg);
    }
}
