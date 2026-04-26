package com.learning.graphql_playground.lec13.dto;

import com.learning.graphql_playground.lec13.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor
@Builder
public class DeleteResponseDto {
    private Integer id;
    private Status status;
}
