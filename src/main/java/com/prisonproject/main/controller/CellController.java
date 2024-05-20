package com.prisonproject.main.controller;

import com.prisonproject.main.dto.request.AddCellRequest;
import com.prisonproject.main.entity.CellEntity;
import com.prisonproject.main.service.CellService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cell")
@AllArgsConstructor
@Tag(name = "Api for cells managing")
public class CellController {
    private final CellService cellService;

    @PutMapping("/add")
    @Operation(summary = "Get all cells")
    public CellEntity addCell(@RequestBody AddCellRequest request){
        return cellService.addCell(request);
    }
}
