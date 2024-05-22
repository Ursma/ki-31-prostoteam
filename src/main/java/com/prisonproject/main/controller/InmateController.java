package com.prisonproject.main.controller;

import com.prisonproject.main.dto.request.AddInmateRequest;
import com.prisonproject.main.dto.request.GetResponseByCellName;
import com.prisonproject.main.dto.request.GetResponseByName;
import com.prisonproject.main.dto.response.InmateInfoResponse;
import com.prisonproject.main.dto.response.InmateInfoWithoutCellResponse;
import com.prisonproject.main.entity.InmateEntity;
import com.prisonproject.main.service.InmateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inmate")
@AllArgsConstructor
@Tag(name = "Запити для роботи із в'язнями")
public class InmateController {
    private final InmateService inmateService;

    @PutMapping("/add")
    @Operation(summary = "Додати в'язня", description = "Додає в'язня до камери")
    public InmateEntity addInmateToPrison(@RequestBody AddInmateRequest request){
       return inmateService.addInmateToCell(request);
    }

    @PostMapping("/get/full")
    @Operation(summary = "Отримати повню інформацію про в'язня", description = "Повертає повну інформацію про в'язня")
    public InmateInfoResponse getInmateInfo(@RequestBody GetResponseByName body){
        return inmateService.getInmateResponse(body);
    }

    @PostMapping("/get/short")
    @Operation(summary = "Отримати коротку інформацію про в'язня ", description = "Повертає коротку інформацію про в'язня")
    public InmateInfoWithoutCellResponse getShortGuardInfo(@RequestBody GetResponseByName body){
        return inmateService.getShortInmateInfo(body);
    }

    @PostMapping("/get/all")
    @Operation(summary = "Отримати коротку інформацію про всіх в'язнів ", description = "Повертає коротку інформацію про всіх в'язнів")
    public List<InmateInfoWithoutCellResponse> getShortInfoAboutAllGuards(){
        return inmateService.getShortInfoAboutAllInmates();
    }

    @PostMapping("/get/by/cell")
    @Operation(summary = "Отримати в'язнів по певній камері", description = "Повертає усіх пов'язаних із камерою в'язнів")
    public List<InmateInfoWithoutCellResponse> getAllGuardsByCellId(@RequestBody GetResponseByCellName body){
        return inmateService.getAllInmatesByCell(body);
    }
}
