package com.learning.graphql_playground.lec11.dto;

import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor
public class Electronic{
    private UUID id = UUID.randomUUID();
    private String description;
    private Integer price;
    private Brand brand;
}
