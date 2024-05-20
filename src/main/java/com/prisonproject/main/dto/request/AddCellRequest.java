package com.prisonproject.main.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddCellRequest {
    private Integer cellNumber;
    private Integer currentOccupancy;
    private Integer capacity;
}
