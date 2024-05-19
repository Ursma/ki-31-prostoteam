package com.prisonproject.main.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class CrimeInfoResponse {
    private String state;
    private String durability;
}
