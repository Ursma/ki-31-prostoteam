package com.prisonproject.main.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class GetEventByPeriodOfTimeAndName {
        private LocalDate first;
        private LocalDate second;
        private String name;
}
