package com.learning.graphql_playground.lec11.dto;

import lombok.*;

@Data
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor
public class FruitDto {
    private String description;
    private String expiryDate;
}
