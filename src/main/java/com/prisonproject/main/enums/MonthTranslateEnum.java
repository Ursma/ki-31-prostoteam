package com.prisonproject.main.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Month;
import java.util.*;

@AllArgsConstructor
@Getter
public enum MonthTranslateEnum {
    JANUARY(Month.JANUARY,"Січень"),
    FEBRUARY(Month.FEBRUARY,"Лютий"),
    MARCH(Month.MARCH,"Березня"),
    APRIL(Month.APRIL,"Квітня"),
    MAY(Month.MAY,"Травня"),
    JUNE(Month.JUNE,"Червня"),
    JULY(Month.JULY,"Липеня"),
    AUGUST(Month.AUGUST,"Серпеня"),
    SEPTEMBER(Month.SEPTEMBER,"Вересня"),
    OCTOBER(Month.OCTOBER,"Жовтня"),
    NOVEMBER(Month.NOVEMBER,"Листопада"),
    DECEMBER(Month.DECEMBER,"Грудня");

    private final Month month;
    private final String description;
    private static final Map<Month, String> ENUM_MAP = new HashMap<>();

    static {
        for (MonthTranslateEnum e : values()) {
            ENUM_MAP.put(e.month, e.description);
        }
    }

    public static String getDescription(Month month){
        return ENUM_MAP.get(month);
    }
}
