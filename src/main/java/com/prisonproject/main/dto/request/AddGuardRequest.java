package com.prisonproject.main.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@Getter
@AllArgsConstructor
public class AddGuardRequest {
    private String name;
    private Instant birthday;
    private Instant startDate;
    private Integer gender;
    private Integer cellId;
    private Integer shift;
}
