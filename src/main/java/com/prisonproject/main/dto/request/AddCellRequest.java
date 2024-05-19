package com.prisonproject.main.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddCellRequest {
    private Integer cellNumber;
    private Integer currentOccupancy;
    private Integer capacity;
}
