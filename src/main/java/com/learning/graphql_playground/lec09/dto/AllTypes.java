package com.learning.graphql_playground.lec09.dto;

import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor
public class AllTypes {
    private UUID id;
    private Integer height;
    private Float temperature;
    private String city;
    private Boolean isValid;
    private Long distance;
    private Byte ageInYears;
    private Short ageInMonths;
    private BigDecimal bigDecimal;
    private BigInteger bigInteger;
    private LocalDate date;
    private LocalTime time;
    private OffsetDateTime dateTime;
    private Car car;
}
