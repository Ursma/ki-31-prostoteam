package com.prisonproject.main.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class CellInfoWithoutGuardResponse {
    private String cellNumber;
    private List<InmateInfoWithoutCellResponse> inmates;
    private String currentCapacity;
}
