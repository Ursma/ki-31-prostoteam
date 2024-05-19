package com.prisonproject.main.controller;

import com.prisonproject.main.dto.request.AddInmateRequest;
import com.prisonproject.main.dto.request.GetResponseById;
import com.prisonproject.main.dto.response.InmateInfoResponse;
import com.prisonproject.main.entity.InmateEntity;
import com.prisonproject.main.service.InmateService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inmate")
@AllArgsConstructor
public class InmateController {
    private final InmateService inmateService;

    @PutMapping("/add")
    public InmateEntity addInmateToPrison(@RequestBody AddInmateRequest request){
       return inmateService.addInmateToCell(request);
    }

    @PostMapping("/get")
    public InmateInfoResponse getInmateInfo(@RequestBody GetResponseById body){
        return inmateService.getInmateResponse(body);
    }
}
