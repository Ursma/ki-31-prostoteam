package com.prisonproject.main.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CrimeRequest {
    private Integer crimeType;
    private Integer durability;
}
