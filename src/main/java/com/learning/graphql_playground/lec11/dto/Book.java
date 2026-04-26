package com.learning.graphql_playground.lec11.dto;

import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor
public class Book{
    private String description;
    private String author;
}
