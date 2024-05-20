package com.prisonproject.main.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class InmateInfoForEventResponse {
    private String name;
    private String gender;
    private List<CrimeInfoResponse> crimes;
    private String cell;
}
