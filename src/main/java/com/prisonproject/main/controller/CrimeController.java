package com.prisonproject.main.controller;

import com.prisonproject.main.dto.request.AddCrimeRequest;
import com.prisonproject.main.entity.CrimeEntity;
import com.prisonproject.main.service.CrimeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crime")
@AllArgsConstructor
public class CrimeController {
    private final CrimeService crimeService;

    @PutMapping("/add")
    public CrimeEntity addCrime(@RequestBody AddCrimeRequest request){
        return crimeService.addCrime(request);
    }
}