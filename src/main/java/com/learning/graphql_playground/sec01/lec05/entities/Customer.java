package com.learning.graphql_playground.sec01.lec05.entities;

import com.learning.graphql_playground.sec01.lec05.dto.Account;
import com.learning.graphql_playground.sec01.lec05.dto.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor
public class Customer {
    private Integer id;

    private String name;

    private Integer age;
}
