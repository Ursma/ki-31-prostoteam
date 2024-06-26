package com.prisonproject.main.controller;

import com.prisonproject.main.dto.request.AddCrimeRequest;
import com.prisonproject.main.dto.response.CrimeInfoResponse;
import com.prisonproject.main.entity.CrimeEntity;
import com.prisonproject.main.service.CrimeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crime")
@AllArgsConstructor
@Tag(name = "Запити для роботи зі статями")
public class CrimeController {
    private final CrimeService crimeService;

    @PutMapping("/add")
    @Operation(summary = "Додати нову статю", description = "Додає статю з терміном ув'язнення")
    public CrimeEntity addCrime(@RequestBody AddCrimeRequest request){
        return crimeService.addCrime(request);
    }
    @PostMapping("/get/all")
    @Operation(summary = "Додати нову статю", description = "Додає статю з терміном ув'язнення")
    public List<CrimeInfoResponse> getAllCrimes(){
        return crimeService.getAllCrimes();
    }

}
