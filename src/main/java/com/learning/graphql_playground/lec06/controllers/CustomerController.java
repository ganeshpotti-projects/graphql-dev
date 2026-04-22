package com.learning.graphql_playground.lec06.controllers;

import com.learning.graphql_playground.lec06.dto.CustomerOrder;
import com.learning.graphql_playground.lec06.dto.CustomerWithOrder;
import com.learning.graphql_playground.lec06.entities.Customer;
import com.learning.graphql_playground.lec06.services.CustomerOrderDataFetcher;
import com.learning.graphql_playground.lec06.services.CustomerService;
import com.learning.graphql_playground.lec06.services.OrderService;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    private final OrderService orderService;

    private final CustomerOrderDataFetcher customerOrderDataFetcher;

//    @SchemaMapping(
//            typeName = "Query"
//    )
//    public Flux<Customer> customers(){
//        return customerService.allCustomers();
//    }

//    @SchemaMapping(
//            typeName = "Customer"
//    )
//    public Flux<CustomerOrder> orders(Customer customer){
//        return orderService.ordersByCustomerName(customer.getName());
//    }

    @SchemaMapping(
            typeName = "Query"
    )
    public Flux<CustomerWithOrder> customers(DataFetchingEnvironment dataFetchingEnvironment){
        return customerOrderDataFetcher.customerOrders(dataFetchingEnvironment);
    }
}
