package com.prisonproject.main.controller;

import com.prisonproject.main.dto.request.AddCellRequest;
import com.prisonproject.main.entity.CellEntity;
import com.prisonproject.main.service.CellService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cell")
@AllArgsConstructor
@Tag(name = "Api for cells managing")
public class CellController {
    private final CellService cellService;

    @PutMapping("/add")
    @CrossOrigin(origins = "http://127.0.0.1:8081")
    @Operation(summary = "Get all cells")
    public CellEntity addCell(@RequestBody AddCellRequest request){
        return cellService.addCell(request);
    }
}
