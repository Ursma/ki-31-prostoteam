package com.prisonproject.main.controller;

import com.prisonproject.main.dto.AddCellRequest;
import com.prisonproject.main.service.CellService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cell")
@AllArgsConstructor
public class CellController {
    @NonNull
    private final CellService cellService;

    @PutMapping("/add")
    public void addCell(@RequestBody AddCellRequest request){
        cellService.addCell(request);
    }
}
