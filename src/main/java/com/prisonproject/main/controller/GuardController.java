package com.prisonproject.main.controller;

import com.prisonproject.main.dto.request.AddGuardRequest;
import com.prisonproject.main.dto.request.GetResponseById;
import com.prisonproject.main.dto.response.GuardInfoResponse;
import com.prisonproject.main.dto.response.GuardInfoWithoutCellResponse;
import com.prisonproject.main.entity.GuardEntity;
import com.prisonproject.main.service.GuardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/guard")
@Tag(name = "Запити для роботи з охороною")
public class GuardController {
    private final GuardService guardService;

    @PutMapping("/add")
    @Operation(summary = "Додати охоронника", description = "Додає охоронника у базу")
    public GuardEntity addGuard(@RequestBody AddGuardRequest request){
        return guardService.addGuard(request);
    }


    @PostMapping("/get/full")
    @Operation(summary = "Отримати детальну інформацію про охоронця та камери за якими він закріплений", description = "Повертає детальну інформацію про охоронця")
    public GuardInfoResponse getGuardInfo(@RequestBody GetResponseById body){
        return guardService.getGuardInfo(body);
    }

    @PostMapping("/get/short")
    @Operation(summary = "Отримати коротку інформацію про охоронця ", description = "Повертає коротку інформацію про охоронця")
    public GuardInfoWithoutCellResponse getShortGuardInfo(@RequestBody GetResponseById body){
        return guardService.getShortGuardInfo(body);
    }

    @PostMapping("/get/all")
    @Operation(summary = "Отримати коротку інформацію про всіх охоронців ", description = "Повертає коротку інформацію про всіх охоронців")
    public List<GuardInfoWithoutCellResponse> getShortInfoAboutAllGuards(){
        return guardService.getShortInfoAboutAllGuards();
    }

    @PostMapping("/get/by/cell")
    @Operation(summary = "Отримати охоронців по певній камері", description = "Повертає усіх пов'язаних із камерою охоронців")
    public List<GuardInfoWithoutCellResponse> getAllGuardsByCellId(@RequestBody GetResponseById body){
        return guardService.getAllGuardsByCell(body);
    }
}
