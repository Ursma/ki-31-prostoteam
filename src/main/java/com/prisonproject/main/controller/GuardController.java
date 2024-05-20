package com.prisonproject.main.controller;

import com.prisonproject.main.dto.request.AddGuardRequest;
import com.prisonproject.main.entity.GuardEntity;
import com.prisonproject.main.service.GuardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/guard")
@Tag(name = "Api for guards managing")
public class GuardController {
    private final GuardService guardService;

    @PutMapping("/add")
    @Operation(summary = "Get all guards", description = "Returns a list of all guards")
    public GuardEntity addGuard(@RequestBody AddGuardRequest request){
        return guardService.addGuard(request);
    }

}
