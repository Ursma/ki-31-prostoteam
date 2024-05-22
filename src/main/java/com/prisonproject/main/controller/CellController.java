package com.prisonproject.main.controller;

import com.prisonproject.main.dto.request.AddCellRequest;
import com.prisonproject.main.dto.request.GetResponseByCellName;
import com.prisonproject.main.dto.response.CellInfoResponse;
import com.prisonproject.main.entity.CellEntity;
import com.prisonproject.main.service.CellService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cell")
@AllArgsConstructor
@Tag(name = "Запити для роботи з камерами")
public class CellController {
    private final CellService cellService;

    @PutMapping("/add")
    @Operation(summary = "Get all cells")
    public CellEntity addCell(@RequestBody AddCellRequest request){
        return cellService.addCell(request);
    }

    @PostMapping("/get")
    @Operation(summary = "Get all cells")
    public CellInfoResponse addCell(@RequestBody GetResponseByCellName request){
        return cellService.getCellInfoByCellName(request);
    }
}
