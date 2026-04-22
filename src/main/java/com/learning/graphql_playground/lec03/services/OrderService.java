package com.learning.graphql_playground.lec03.services;

import com.learning.graphql_playground.lec03.dto.CustomerOrder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.*;

@Service
public class OrderService {

    private final Map<String, List<CustomerOrder>> map = Map.of(
            "sam", List.of(
                    CustomerOrder.create(UUID.randomUUID(), "iphone 17 pro"),
                    CustomerOrder.create(UUID.randomUUID(), "iwatch ultra")
            ),
            "jolly", List.of(
                    CustomerOrder.create(UUID.randomUUID(), "samsung a24"),
                    CustomerOrder.create(UUID.randomUUID(), "noise earz4")
            )
    );

    public Flux<CustomerOrder> ordersByCustomerName(String name){
        return Flux.fromIterable(map.getOrDefault(name, Collections.emptyList()));
    }
}
