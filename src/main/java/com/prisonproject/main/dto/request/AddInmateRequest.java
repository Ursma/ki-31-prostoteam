package com.prisonproject.main.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddInmateRequest {
    private String name;
    private Instant birthday;
    private Integer gender;
    private Instant startDate;
    private Instant endDate;
    private List<Integer> crimeIds;
    private Integer cellId;
}
