package com.prisonproject.main.mapper;

import com.prisonproject.main.dto.response.*;
import com.prisonproject.main.entity.CellEntity;
import com.prisonproject.main.entity.GuardEntity;
import com.prisonproject.main.entity.InmateEntity;
import com.prisonproject.main.enums.GenderTypeEnum;
import com.prisonproject.main.enums.MonthTranslateEnum;
import com.prisonproject.main.enums.ShiftEnum;
import com.prisonproject.main.repository.GuardRepository;
import com.prisonproject.main.repository.InmateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Component
public class GlobalResponseMapper {
    protected static final String CELL_NUMBER = "Камера номер ";
    protected static final String CURRENT_OCCUPANCY = "Місця в камері ";
    protected static final String BIRTH_DATE = "Дата народження ";
    protected static final String YEAR = " року";
    protected static final String REGISTRATED = "Зареєстровано ";
    protected static final String FREE = "Дата визволення ";
    protected static final String STATE = "Статя ";
    protected static final String DURABILITY = "Років ув'язнення ";

    private final GuardRepository guardRepository;
    private final InmateRepository inmateRepository;
    public InmateInfoResponse inmateEntityToResponse(InmateEntity entity){
        return InmateInfoResponse.builder()
                .name(entity.getName())
                .cell(CellInfoWithoutInmateResponse.builder()
                        .cellNumber(CELL_NUMBER + entity.getCellEntity().getCellName())
                        .currentCapacity(CURRENT_OCCUPANCY + entity.getCellEntity().getCurrentOccupancy() + "/" + entity.getCellEntity().getCapacity())
                        .guards(guardRepository.findAllByCellEntity(entity.getCellEntity())
                                .stream()
                                .map(g -> GuardInfoWithoutCellResponse.builder()
                                        .gender(GenderTypeEnum.getDescriptionByGenderType(g.getGender()))
                                        .birthday(BIRTH_DATE + g.getBirthday().getDayOfMonth() + " " +
                                                MonthTranslateEnum.getDescription(g.getBirthday().getMonth()) + " " +
                                                g.getBirthday().getYear() + YEAR)
                                        .startDate(REGISTRATED + g.getStartDate().getDayOfMonth() + " " +
                                                MonthTranslateEnum.getDescription(g.getStartDate().getMonth()) + " " +
                                                g.getStartDate().getYear() + YEAR)
                                        .name(g.getName())
                                        .shift(ShiftEnum.getDescriptionByNum(g.getShift()))
                                        .build())
                                .toList())
                        .build())
                .endDate(FREE + entity.getEndDate().getDayOfMonth() + " " +
                MonthTranslateEnum.getDescription(entity.getEndDate().getMonth()) + " " +
                        entity.getEndDate().getYear() + YEAR)
                .birthday(BIRTH_DATE + entity.getBirthday().getDayOfMonth() + " " +
                        MonthTranslateEnum.getDescription(entity.getBirthday().getMonth()) + " " +
                        entity.getBirthday().getYear() + YEAR)
                .startDate(REGISTRATED + entity.getStartDate().getDayOfMonth() + " " +
                        MonthTranslateEnum.getDescription(entity.getBirthday().getMonth()) + " " +
                        entity.getBirthday().getYear() + YEAR)
                .crimes(entity.getCrimeEntityList()
                        .stream()
                        .map(c ->  CrimeInfoResponse.builder()
                                .state(STATE + c.getCrimeNumber())
                                .durability(DURABILITY + c.getDurability())
                                .build())
                        .toList())
                .gender(GenderTypeEnum.getDescriptionByGenderType(entity.getGender()))
                .build();
    }

    public CellInfoResponse cellEntityToResponse(CellEntity entity){
        return CellInfoResponse.builder()
                .currentCapacity(CURRENT_OCCUPANCY + entity.getCurrentOccupancy() + "/" + entity.getCapacity())
                .cellNumber(CELL_NUMBER + entity.getCellName())
                .inmates(inmateRepository.findAllByCellEntity(entity)
                        .stream()
                        .map(i -> InmateInfoWithoutCellResponse.builder()
                                .name(i.getName())
                                .endDate(FREE + i.getEndDate().getDayOfMonth() + " " +
                                        MonthTranslateEnum.getDescription(i.getEndDate().getMonth()) + " " +
                                        i.getEndDate().getYear() + YEAR)
                                .birthday(BIRTH_DATE + i.getBirthday().getDayOfMonth() + " " +
                                        MonthTranslateEnum.getDescription(i.getBirthday().getMonth()) + " " +
                                        i.getBirthday().getYear() + YEAR)
                                .startDate(REGISTRATED + i.getStartDate().getDayOfMonth() + " " +
                                        MonthTranslateEnum.getDescription(i.getStartDate().getMonth()) + " " +
                                        i.getStartDate().getYear() + YEAR)
                                .gender(GenderTypeEnum.getDescriptionByGenderType(i.getGender()))
                                .crimes(i.getCrimeEntityList()
                                        .stream()
                                        .map(c ->  CrimeInfoResponse.builder()
                                                .state(STATE + c.getCrimeNumber())
                                                .durability(DURABILITY + c.getDurability())
                                                .build())
                                        .toList())
                                .build())
                        .toList())
                .guards(guardRepository.findAllByCellEntity(entity)
                        .stream()
                        .map(g -> GuardInfoWithoutCellResponse.builder()
                                .gender(GenderTypeEnum.getDescriptionByGenderType(g.getGender()))
                                .birthday(BIRTH_DATE + g.getBirthday().getDayOfMonth() + " " +
                                        MonthTranslateEnum.getDescription(g.getBirthday().getMonth()) + " " +
                                        g.getBirthday().getYear() + YEAR)
                                .startDate(REGISTRATED + g.getStartDate().getDayOfMonth() + " " +
                                        MonthTranslateEnum.getDescription(g.getStartDate().getMonth()) + " " +
                                        g.getStartDate().getYear() + YEAR)
                                .name(g.getName())
                                .build())
                        .toList())
                .build();
    }

    public GuardInfoResponse guardEntityToResponse(GuardEntity entity){
        return GuardInfoResponse.builder()
                .gender(GenderTypeEnum.getDescriptionByGenderType(entity.getGender()))
                .birthday(BIRTH_DATE + entity.getBirthday().getDayOfMonth() + " " +
                        MonthTranslateEnum.getDescription(entity.getBirthday().getMonth()) + " " +
                        entity.getBirthday().getYear() + YEAR)
                .startDate(REGISTRATED + entity.getStartDate().getDayOfMonth() + " " +
                        MonthTranslateEnum.getDescription(entity.getStartDate().getMonth()) + " " +
                        entity.getStartDate().getYear() + YEAR)
                .name(entity.getName())
                .shift(ShiftEnum.getDescriptionByNum(entity.getShift()))
                .cell(CellInfoWithoutGuardResponse.builder()
                        .inmates(inmateRepository.findAllByCellEntity(entity.getCellEntity())
                                .stream()
                                .map(i -> InmateInfoWithoutCellResponse.builder()
                                        .name(i.getName())
                                        .endDate(FREE + i.getEndDate().getDayOfMonth() + " " +
                                                MonthTranslateEnum.getDescription(i.getEndDate().getMonth()) + " " +
                                                i.getEndDate().getYear() + YEAR)
                                        .birthday(BIRTH_DATE + i.getBirthday().getDayOfMonth() + " " +
                                                MonthTranslateEnum.getDescription(i.getBirthday().getMonth()) + " " +
                                                i.getBirthday().getYear() + YEAR)
                                        .startDate(REGISTRATED + i.getStartDate().getDayOfMonth() + " " +
                                                MonthTranslateEnum.getDescription(i.getStartDate().getMonth()) + " " +
                                                i.getStartDate().getYear() + YEAR)
                                        .gender(GenderTypeEnum.getDescriptionByGenderType(i.getGender()))
                                        .crimes(i.getCrimeEntityList()
                                                .stream()
                                                .map(c ->  CrimeInfoResponse.builder()
                                                        .state(STATE + c.getCrimeNumber())
                                                        .durability(DURABILITY + c.getDurability())
                                                        .build())
                                                .toList())
                                        .build())
                                .toList())
                        .cellNumber(CELL_NUMBER + entity.getCellEntity().getCellName())
                        .currentCapacity(CURRENT_OCCUPANCY + entity.getCellEntity().getCurrentOccupancy() + "/" + entity.getCellEntity().getCapacity())
                        .build())
                .build();
    }

    public GuardInfoWithoutCellResponse guardEntityToShortInfoResponse(GuardEntity entity) {
        return GuardInfoWithoutCellResponse.builder()
                .name(entity.getName())
                .shift(ShiftEnum.getDescriptionByNum(entity.getShift()))
                .startDate(REGISTRATED + entity.getStartDate().getDayOfMonth() + " " +
                        MonthTranslateEnum.getDescription(entity.getStartDate().getMonth()) + " " +
                        entity.getStartDate().getYear() + YEAR)
                .birthday(BIRTH_DATE +entity.getBirthday().getDayOfMonth() + " " +
                        MonthTranslateEnum.getDescription(entity.getBirthday().getMonth()) + " " +
                        entity.getBirthday().getYear() + YEAR)
                .gender(GenderTypeEnum.getDescriptionByGenderType(entity.getGender()))
                .build();
    }

    public InmateInfoWithoutCellResponse inmateEntityToShortResponse(InmateEntity entity) {
        return InmateInfoWithoutCellResponse.builder()
                .name(entity.getName())
                .gender(GenderTypeEnum.getDescriptionByGenderType(entity.getGender()))
                .endDate(FREE + entity.getEndDate().getDayOfMonth() + " " +
                        MonthTranslateEnum.getDescription(entity.getEndDate().getMonth()) + " " +
                        entity.getEndDate().getYear() + YEAR)
                .birthday(BIRTH_DATE + entity.getBirthday().getDayOfMonth() + " " +
                        MonthTranslateEnum.getDescription(entity.getBirthday().getMonth()) + " " +
                        entity.getBirthday().getYear() + YEAR)
                .startDate(REGISTRATED + entity.getStartDate().getDayOfMonth() + " " +
                        MonthTranslateEnum.getDescription(entity.getStartDate().getMonth()) + " " +
                        entity.getStartDate().getYear() + YEAR)
                .crimes(entity.getCrimeEntityList().stream().map(c -> CrimeInfoResponse.builder()
                        .state(STATE + c.getCrimeNumber())
                        .durability(DURABILITY + c.getDurability())
                        .build()).toList())
                .build();
    }
}

