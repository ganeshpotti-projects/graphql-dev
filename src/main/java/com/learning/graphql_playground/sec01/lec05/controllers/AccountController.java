package com.learning.graphql_playground.sec01.lec05.controllers;

import com.learning.graphql_playground.sec01.lec05.dto.Account;
import com.learning.graphql_playground.sec01.lec05.entities.Customer;
import com.learning.graphql_playground.sec01.lec05.enums.AccountType;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class AccountController {

    @SchemaMapping(typeName = "Customer")
    public Mono<Account> account(Customer customer){
        return Mono.just(Account.create(UUID.randomUUID(), ThreadLocalRandom.current().nextInt(1, 1000), AccountType.SAVINGS));
    }
}
