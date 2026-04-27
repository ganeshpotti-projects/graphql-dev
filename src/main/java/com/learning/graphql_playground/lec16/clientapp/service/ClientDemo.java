package com.learning.graphql_playground.lec16.clientapp.service;

import com.learning.graphql_playground.lec16.clientapp.client.CustomerClient;
import com.learning.graphql_playground.lec16.dto.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientDemo implements CommandLineRunner {

    private final CustomerClient client;

    @Override
    public void run(String... args) throws Exception {
        rawQueryDemo()
                .then(getCustomerById())
                .subscribe();
    }

    private Mono<Void> rawQueryDemo(){
        String query = """
                {
                    customers{
                        id
                        name
                        age
                        city
                    }
                }
                """;
        Mono<List<CustomerDto>> customers = client.rawQuery(query)
                .map(cr -> cr.field("customers").toEntityList(CustomerDto.class));
        return executor("Raw query 1", customers);

    }

    private Mono<Void> getCustomerById(){
        return executor("Raw query 2", client.getCustomerById(1));
    }

    private <T> Mono<Void> executor(String message, Mono<T> mono){
        return Mono.delay(Duration.ofSeconds(1))
                .doFirst(() -> System.out.println(message))
                .then(mono)
                .doOnNext(System.out::println)
                .then();
    }
}
