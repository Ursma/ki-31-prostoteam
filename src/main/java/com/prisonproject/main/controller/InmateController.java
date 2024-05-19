package com.prisonproject.main.controller;

import com.prisonproject.main.dto.AddInmateRequest;
import com.prisonproject.main.entity.InmateEntity;
import com.prisonproject.main.service.InmateService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inmate")
@AllArgsConstructor
public class InmateController {
    private final InmateService inmateService;

    @PutMapping("/add")
    public InmateEntity addInmateToPrison(@RequestBody AddInmateRequest request){
       return inmateService.addInmateToCell(request);
    }
}
