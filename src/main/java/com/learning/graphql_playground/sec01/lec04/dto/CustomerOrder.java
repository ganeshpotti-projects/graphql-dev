package com.learning.graphql_playground.sec01.lec04.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor
@Builder
public class CustomerOrder {
    private UUID id;

    private String description;
}
