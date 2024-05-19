package com.prisonproject.main.controller;

import com.prisonproject.main.dto.AddCrimeRequest;
import com.prisonproject.main.service.CrimeService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
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
    public void addCrime(@RequestBody AddCrimeRequest request){
        crimeService.addCrime(request);
    }
}
