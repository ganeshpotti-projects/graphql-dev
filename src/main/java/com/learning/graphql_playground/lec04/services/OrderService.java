package com.learning.graphql_playground.lec04.services;

import com.learning.graphql_playground.lec04.dto.CustomerOrder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

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
        return Flux.fromIterable(names).flatMapSequential(name ->
                fetchOrders(name)
                        .defaultIfEmpty(Collections.emptyList())
        );
    }

    public Mono<List<CustomerOrder>> fetchOrders(String name){
        return Mono.justOrEmpty(map.get(name))
                .delayElement(Duration.ofMillis(ThreadLocalRandom.current().nextInt(0, 500)));
    }
}
