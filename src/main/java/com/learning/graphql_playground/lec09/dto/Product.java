package com.learning.graphql_playground.lec09.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor
public class Product {
    private String name;
    private Object attributes;
}
