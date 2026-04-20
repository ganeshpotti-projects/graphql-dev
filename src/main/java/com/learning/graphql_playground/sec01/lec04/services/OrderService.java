package com.learning.graphql_playground.sec01.lec04.services;

import com.learning.graphql_playground.sec01.lec04.dto.CustomerOrder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

    public Flux<List<CustomerOrder>> ordersByCustomerName(List<String> names){
        return Flux.fromIterable(names).map(name -> map.getOrDefault(name, Collections.emptyList()));
    }
}
