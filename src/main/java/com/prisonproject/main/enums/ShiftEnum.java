package com.prisonproject.main.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
public enum ShiftEnum {
    DAY_SHIFT(1, "Денна зміна"),
    NIGHT_SHIFT(2, "Нічна зміна");

    private final Integer number;
    private final String description;
    private static final Map<Integer, String> ENUM_MAP = new HashMap<>();

    static {
        for (ShiftEnum e : values()) {
            ENUM_MAP.put(e.number, e.description);
        }
    }

    public static String getDescriptionByNum(Integer num){
        return ENUM_MAP.get(num);
    }
}
