package com.prisonproject.main.controller;

import com.prisonproject.main.dto.request.AddInmateRequest;
import com.prisonproject.main.dto.request.GetResponseById;
import com.prisonproject.main.dto.response.InmateInfoResponse;
import com.prisonproject.main.entity.InmateEntity;
import com.prisonproject.main.service.InmateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inmate")
@AllArgsConstructor
@Tag(name = "Api for inmates managing")
public class InmateController {
    private final InmateService inmateService;

    @PutMapping("/add")
    @Operation(summary = "Add a new inmate", description = "Adds a new inmate to the prison")
    public InmateEntity addInmateToPrison(@RequestBody AddInmateRequest request){
       return inmateService.addInmateToCell(request);
    }

    @PostMapping("/get")
    @Operation(summary = "Get inmate info", description = "Gets information about an inmate")
    public InmateInfoResponse getInmateInfo(@RequestBody GetResponseById body){
        return inmateService.getInmateResponse(body);
    }
}
