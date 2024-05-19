package com.prisonproject.main.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class CellInfoWithoutInmateResponse {
    private String cellNumber;
    private List<GuardInfoWithoutCellResponse> guards;
    private String currentCapacity;
}
