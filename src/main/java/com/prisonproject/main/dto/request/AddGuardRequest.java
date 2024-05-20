package com.prisonproject.main.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddGuardRequest {
    private String name;
    private LocalDate birthday;
    private LocalDate startDate;
    private Integer gender;
    private Integer cellId;
    private Integer shift;
}
