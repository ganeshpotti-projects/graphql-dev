package com.learning.graphql_playground.lec05.controllers;

import com.learning.graphql_playground.lec05.entities.Customer;
import com.learning.graphql_playground.lec05.services.CustomerService;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.DataFetchingFieldSelectionSet;
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
    public Flux<Customer> customers(DataFetchingEnvironment environment, DataFetchingFieldSelectionSet selectionSet){
        System.out.println("customer : " + selectionSet.getFields());
        System.out.println("customer fields: " + environment.getSelectionSet().getFields());
        System.out.println("customer document : " + environment.getDocument());
        System.out.println("customer operation definition : " + environment.getOperationDefinition());
        return customerService.allCustomers();
    }
}
