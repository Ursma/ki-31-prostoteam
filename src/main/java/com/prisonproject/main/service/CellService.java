package com.prisonproject.main.service;

import com.prisonproject.main.dto.request.AddCellRequest;
import com.prisonproject.main.entity.CellEntity;
import com.prisonproject.main.repository.CellRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CellService {
    private final CellRepository cellRepository;

    public CellEntity addCell(AddCellRequest request){
        CellEntity entity = new CellEntity();
        entity.setCellNumber(request.getCellNumber());
        entity.setCapacity(request.getCapacity());
        entity.setCurrentOccupancy(request.getCurrentOccupancy());
        return cellRepository.save(entity);
    }
}
