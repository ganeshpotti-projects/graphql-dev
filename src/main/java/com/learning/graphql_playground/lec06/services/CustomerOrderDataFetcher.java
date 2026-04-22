package com.learning.graphql_playground.lec06.services;

import com.learning.graphql_playground.lec06.dto.CustomerWithOrder;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.function.UnaryOperator;

@Service
@RequiredArgsConstructor
public class CustomerOrderDataFetcher {
    private final CustomerService customerService;

    private final OrderService orderService;

    public Flux<CustomerWithOrder> customerOrders(DataFetchingEnvironment environment){
        var includeOrders = environment.getSelectionSet().contains("orders");
        return customerService.allCustomers()
                .map(c-> CustomerWithOrder.create(c.getId(), c.getName(), c.getAge(), c.getCity(), Collections.emptyList()))
                .transform(this.updateOrdersTransformer(includeOrders));
    }

    private UnaryOperator<Flux<CustomerWithOrder>> updateOrdersTransformer(boolean includeOrders){
        return includeOrders ?
                f->f.flatMap(this::fetchOrders) :
                f -> f;
    }

    private Mono<CustomerWithOrder> fetchOrders(CustomerWithOrder customerWithOrder){
        return orderService.ordersByCustomerName(customerWithOrder.getName())
                .collectList()
                .doOnNext(customerWithOrder::setOrders)
                .thenReturn(customerWithOrder);
    }
}
