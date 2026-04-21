package com.learning.graphql_playground.sec01.lec05.controllers;

import com.learning.graphql_playground.sec01.lec05.dto.Address;
import com.learning.graphql_playground.sec01.lec05.entities.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class AddressController {

    @SchemaMapping(typeName = "Customer")
    public Mono<Address> address(Customer customer){
        return Mono.just(Address.create(customer.getName() + " street", customer.getName() + " city"));
    }
}
