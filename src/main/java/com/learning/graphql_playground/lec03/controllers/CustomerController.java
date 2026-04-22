package com.learning.graphql_playground.lec03.controllers;

import com.learning.graphql_playground.lec03.dto.CustomerOrder;
import com.learning.graphql_playground.lec03.entities.Customer;
import com.learning.graphql_playground.lec03.services.CustomerService;
import com.learning.graphql_playground.lec03.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

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

    @SchemaMapping(
            typeName = "Customer"
    )
    public Flux<CustomerOrder> orders(Customer customer, @Argument Integer limit){
        return orderService.ordersByCustomerName(customer.getName()).take(limit);
    }
}
