package com.prisonproject.main.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CrimeRequest {
    private Integer crimeType;
    private Integer durability;
}
