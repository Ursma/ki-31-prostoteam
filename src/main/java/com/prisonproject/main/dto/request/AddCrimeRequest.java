package com.prisonproject.main.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddCrimeRequest {
    private Integer crimeNumber;
    private Integer durability;
}
