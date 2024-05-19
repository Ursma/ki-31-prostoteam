package com.prisonproject.main.mapper;

import com.prisonproject.main.dto.response.*;
import com.prisonproject.main.entity.CellEntity;
import com.prisonproject.main.entity.GuardEntity;
import com.prisonproject.main.entity.InmateEntity;
import com.prisonproject.main.enums.GenderTypeEnum;
import com.prisonproject.main.repository.GuardRepository;
import com.prisonproject.main.repository.InmateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class GlobalResponseMapper {
    private final GuardRepository guardRepository;
    private final InmateRepository inmateRepository;
    public InmateInfoResponse inmateEntityToResponse(InmateEntity entity){
        return InmateInfoResponse.builder()
                .name(entity.getName())
                .cell(CellInfoWithoutInmateResponse.builder()
                        .cellNumber("Камера номер " + entity.getCellEntity().getCellNumber())
                        .currentCapacity("Місця в камері " + entity.getCellEntity().getCurrentOccupancy() + "/" + entity.getCellEntity().getCapacity())
                        .guards(guardRepository.findAllByCellId(entity.getCellEntity().getId())
                                .stream()
                                .map(g -> GuardInfoWithoutCellResponse.builder()
                                        .gender(GenderTypeEnum.getDescriptionByGenderType(g.getGender()))
                                        .birthday("Дата народження " + g.getBirthday())
                                        .startDate("Зареєстровано " + g.getStartDate())
                                        .name(g.getName())
                                        .build())
                                .toList())
                        .build())
                .endDate("Дата визволення " + entity.getEndDate())
                .birthday("Дата народження " + entity.getBirthday())
                .startDate("Зареєстровано " + entity.getStartDate())
                .crimes(entity.getCrimeEntityList()
                        .stream()
                        .map(c ->  CrimeInfoResponse.builder()
                                .state("Статя " + c.getCrimeNumber())
                                .durability("Років ув'язнення " + c.getDurability())
                                .build())
                        .toList())
                .gender(GenderTypeEnum.getDescriptionByGenderType(entity.getGender()))
                .build();
    }

    public CellInfoResponse cellEntityToResponse(CellEntity entity){
        return CellInfoResponse.builder()
                .currentCapacity("Місця в камері " + entity.getCurrentOccupancy() + "/" + entity.getCapacity())
                .cellNumber("Камера номер " + entity.getCellNumber())
                .inmates(inmateRepository.findAllByCellId(entity.getId())
                        .stream()
                        .map(i -> InmateInfoWithoutCellResponse.builder()
                                .name(i.getName())
                                .endDate("Дата визволення " + i.getEndDate())
                                .birthday("Дата народження " + i.getBirthday())
                                .startDate("Зареєстровано " + i.getStartDate())
                                .gender(GenderTypeEnum.getDescriptionByGenderType(i.getGender()))
                                .crimes(i.getCrimeEntityList()
                                        .stream()
                                        .map(c ->  CrimeInfoResponse.builder()
                                                .state("Статя " + c.getCrimeNumber())
                                                .durability("Років ув'язнення " + c.getDurability())
                                                .build())
                                        .toList())
                                .build())
                        .toList())
                .guards(guardRepository.findAllByCellId(entity.getId())
                        .stream()
                        .map(g -> GuardInfoWithoutCellResponse.builder()
                                .gender(GenderTypeEnum.getDescriptionByGenderType(g.getGender()))
                                .birthday("Дата народження " + g.getBirthday())
                                .startDate("Зареєстровано " + g.getStartDate())
                                .name(g.getName())
                                .build())
                        .toList())
                .build();
    }

    public GuardInfoResponse guardEntityToResponse(GuardEntity entity){
        return GuardInfoResponse.builder()
                .gender(GenderTypeEnum.getDescriptionByGenderType(entity.getGender()))
                .birthday("Дата народження " + entity.getBirthday())
                .startDate("Зареєстровано " + entity.getStartDate())
                .name(entity.getName())
                .cell(CellInfoWithoutGuardResponse.builder()
                        .inmates(inmateRepository.findAllByCellId(entity.getCellId())
                                .stream()
                                .map(i -> InmateInfoWithoutCellResponse.builder()
                                        .name(i.getName())
                                        .endDate("Дата визволення " + i.getEndDate())
                                        .birthday("Дата народження " + i.getBirthday())
                                        .startDate("Зареєстровано " + i.getStartDate())
                                        .gender(GenderTypeEnum.getDescriptionByGenderType(i.getGender()))
                                        .crimes(i.getCrimeEntityList()
                                                .stream()
                                                .map(c ->  CrimeInfoResponse.builder()
                                                        .state("Статя " + c.getCrimeNumber())
                                                        .durability("Років ув'язнення " + c.getDurability())
                                                        .build())
                                                .toList())
                                        .build())
                                .toList())
                        .cellNumber("Камера номер " + entity.getCellEntity().getCellNumber())
                        .currentCapacity("Місця в камері " + entity.getCellEntity().getCurrentOccupancy() + "/" + entity.getCellEntity().getCapacity())
                        .build())
                .build();
    }
}
