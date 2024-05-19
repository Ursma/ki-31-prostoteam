package com.prisonproject.main.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ShiftEnum {
    DAY_SHIFT(1),
    NIGHT_SHIFT(2);

    private final Integer number;
}
