package com.learning.graphql_playground.lec05.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "create")
public class Address {
    private String street;

    private String city;
}
