package com.learning.graphql_playground.sec01.lec02.services;

import com.learning.graphql_playground.sec01.lec02.dto.AgeRangeFilter;
import com.learning.graphql_playground.sec01.lec02.entities.Customer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {
    private final Flux<Customer> flux = Flux.just(
            Customer.create(1, "sam", 22, "pune"),
            Customer.create(2, "john", 26, "guntur"),
            Customer.create(3, "jolly", 25, "hyderabad"),
            Customer.create(4, "belly", 23, "delhi")
    );

    public Flux<Customer> allCustomers(){
        return flux;
    }

    public Mono<Customer> customerById(Integer id){
        return flux.filter(c -> c.getId().equals(id)).next();
    }

    public Flux<Customer> customersByName(String name){
        return flux.filter(c -> c.getName().contains(name));
    }

    public Flux<Customer> customersBetweenAge(AgeRangeFilter ageRangeFilter) {
        return flux.filter(c -> c.getAge()> ageRangeFilter.getMinAge() && c.getAge()< ageRangeFilter.getMaxAge());
    }
}
