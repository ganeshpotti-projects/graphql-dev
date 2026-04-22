package com.learning.graphql_playground.lec02.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgeRangeFilter {
    private Integer minAge;

    private Integer maxAge;
}
