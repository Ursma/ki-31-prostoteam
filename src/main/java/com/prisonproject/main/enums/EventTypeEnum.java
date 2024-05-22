package com.prisonproject.main.enums;

import com.prisonproject.main.dto.response.EventInfoResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EventTypeEnum {
    INMATE_ASSAULT(1,
            "Акт насильства, під час якого один або кілька ув'язнених фізично атакують іншого ув'язненого або працівника тюрми. Це може призвести до серйозних травм або навіть смерті.",
            3,
            "Бійка ув'язнених"),
    ESCAPE_ATTEMPT(2,
            "Інцидент, коли один або кілька ув'язнених намагаються втекти з тюрми. Це може включати підкопи, використання підроблених ключів або інших методів для втечі.",
            5,
            "Спроба втечі"),
    CONTRABAND_SMUGGLING(3,
            "Проникнення заборонених предметів у тюрму, таких як наркотики, зброя, мобільні телефони або інші заборонені речі. Це може бути здійснено ув'язненими або їх відвідувачами.",
            1,
            "Передача контрабанди та заборонених речовин"),
    MEDICAL_EMERGENCY(4,
            "Ситуація, коли ув'язнений потребує негайної медичної допомоги через хворобу, травму або інші медичні проблеми. Це може включати серцевий напад, важке поранення або передозування.",
            0,
            "Хвороба, травма, або інші медичні проблеми в'язня"),
    WEAPON_DISCOVERY(5,
            "Виявлення вогнепальної або холодної зброї у ув'язнених або в їхніх камерах. Це може становити серйозну загрозу для безпеки тюрми та потребує негайної реакції охорони.",
            5,
            "Виявлення зброї"),
    UDO(6,
            "Гарна поведінка, виконання суспільних робіт дозволяють зменшити строк ув'язнення на 2 роки",
            -2,
            "Дострокове визволення");
    private final Integer eventType;
    private final String description;
    private final Integer durability;
    private final String name;

    public static String getDescriptionByEventNumber(Integer eventNumber) {
        for (EventTypeEnum event : EventTypeEnum.values()) {
            if (event.getEventType().equals(eventNumber)) {
                return event.getDescription();
            }
        }
        throw new IllegalArgumentException("Подію не знайдено"); // или вы можете выбросить исключение, если гендер не найден
    }

    public static Integer getDurabilityByEventNumber(Integer eventNumber) {
        for (EventTypeEnum event : EventTypeEnum.values()) {
            if (event.getEventType().equals(eventNumber)) {
                return event.getDurability();
            }
        }
        throw new IllegalArgumentException("Подію не знайдено"); // или вы можете выбросить исключение, если гендер не найден
    }

    public static String getNameByEventNumber(Integer eventNumber) {
        for (EventTypeEnum event : EventTypeEnum.values()) {
            if (event.getEventType().equals(eventNumber)) {
                return event.getName();
            }
        }
        throw new IllegalArgumentException("Подію не знайдено"); // или вы можете выбросить исключение, если гендер не найден
    }
}
