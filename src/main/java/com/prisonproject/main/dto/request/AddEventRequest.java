package com.prisonproject.main.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddEventRequest {
    private Integer eventNumber;
    private List<String> inmateNames;
    private List<String> guardNames;
    private LocalDate date;
}
