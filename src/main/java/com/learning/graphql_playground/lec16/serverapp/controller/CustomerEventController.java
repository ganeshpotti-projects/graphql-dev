package com.learning.graphql_playground.lec16.serverapp.controller;

import com.learning.graphql_playground.lec16.dto.CustomerEvent;
import com.learning.graphql_playground.lec16.serverapp.services.CustomerEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
@RequiredArgsConstructor
public class CustomerEventController {
    private final CustomerEventService customerEventService;

    @SubscriptionMapping
    public Flux<CustomerEvent> customerEvent(){
        return customerEventService.subscribe();
    }
}
