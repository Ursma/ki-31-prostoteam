package com.prisonproject.main.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum GenderTypeEnum {
    MALE(1, "Чоловіча стать"),
    FEMALE(2, "Жіноча стать");

    private final Integer genderType;
    private final String description;
    public static String getDescriptionByGenderType(Integer genderType) {
        for (GenderTypeEnum gender : GenderTypeEnum.values()) {
            if (gender.getGenderType().equals(genderType)) {
                return gender.getDescription();
            }
        }
        return null; // или вы можете выбросить исключение, если гендер не найден
    }
}
