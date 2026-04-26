package com.learning.graphql_playground.lec13.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private Integer id;

    private String name;

    private Integer age;

    private String city;
}
