package com.learning.graphql_playground.lec05.services;

import com.learning.graphql_playground.lec05.entities.Customer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class CustomerService {
    private final Flux<Customer> flux = Flux.just(
            Customer.create(1, "sam", 22),
            Customer.create(2, "john", 26),
            Customer.create(3, "jolly", 25),
            Customer.create(4, "belly", 23)
    );

    public Flux<Customer> allCustomers(){
        return flux;
    }
}
