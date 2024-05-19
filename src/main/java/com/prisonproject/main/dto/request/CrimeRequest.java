package com.prisonproject.main.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CrimeRequest {
    private Integer crimeType;
    private Integer durability;
}
