package com.learning.graphql_playground.lec16.dto;

import com.learning.graphql_playground.lec16.enums.Status;
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
