package com.learning.graphql_playground.lec14.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor
public class Customer {

    @Id
    private Integer id;

    private String name;

    private Integer age;

    private String city;
}
