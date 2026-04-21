package com.learning.graphql_playground.sec01.lec04.controllers;

import com.learning.graphql_playground.sec01.lec04.dto.CustomerOrder;
import com.learning.graphql_playground.sec01.lec04.entities.Customer;
import com.learning.graphql_playground.sec01.lec04.services.CustomerService;
import com.learning.graphql_playground.sec01.lec04.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    private final OrderService orderService;

    @SchemaMapping(
            typeName = "Query"
    )
    public Flux<Customer> customers(){
        return customerService.allCustomers();
    }

    @BatchMapping(
            typeName = "Customer"
    )
    public Flux<List<CustomerOrder>> orders(List<Customer> customers){
        return orderService.ordersByCustomerName(
                customers.stream().map(Customer::getName).collect(Collectors.toList())
        );
    }
}
