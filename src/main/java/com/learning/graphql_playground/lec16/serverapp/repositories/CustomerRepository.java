package com.learning.graphql_playground.lec16.serverapp.repositories;

import com.learning.graphql_playground.lec16.serverapp.entities.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends ReactiveCrudRepository<Customer, Integer> {
}
