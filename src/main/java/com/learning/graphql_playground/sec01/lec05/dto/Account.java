package com.learning.graphql_playground.sec01.lec05.dto;

import com.learning.graphql_playground.sec01.lec05.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor
public class Account {
    private UUID id;

    private Integer amount;

    private AccountType accountType;
}
