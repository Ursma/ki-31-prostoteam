package com.prisonproject.main.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddGuardRequest {
    private String name;
    private Instant birthday;
    private Instant startDate;
    private Integer gender;
    private Integer cellId;
    private Integer shift;
}
