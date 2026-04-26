package com.learning.graphql_playground.lec10.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor
public class Electronic{
    private UUID id = UUID.randomUUID();
    private String description;
    private Integer price;
    private Brand brand;
}
