package com.prisonproject.main.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddCrimeRequest {
    private Integer crimeNumber;
    private Integer durability;
}
