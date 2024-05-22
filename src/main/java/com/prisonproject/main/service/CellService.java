package com.prisonproject.main.service;

import com.prisonproject.main.dto.request.AddCellRequest;
import com.prisonproject.main.dto.request.GetResponseByCellName;
import com.prisonproject.main.dto.response.CellInfoResponse;
import com.prisonproject.main.entity.CellEntity;
import com.prisonproject.main.mapper.GlobalResponseMapper;
import com.prisonproject.main.repository.CellRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CellService {
    private final CellRepository cellRepository;
    private final GlobalResponseMapper globalResponseMapper;

    public CellEntity addCell(AddCellRequest request){
        checkIsValidName(request.getCellName());
        if(request.getCapacity()==null || request.getCapacity() == 0) throw new IllegalArgumentException("Вмістимість камери не може бути нулем");
        CellEntity entity = new CellEntity();
        entity.setCellName(request.getCellName());
        entity.setCapacity(request.getCapacity());
        entity.setCurrentOccupancy(0);
        return cellRepository.save(entity);
    }

    private void checkIsValidName(String cellName) {
        if(Boolean.TRUE.equals(cellRepository.existsCellEntityByCellName(cellName))) throw new EntityExistsException("Камера з такою назвою вже існує");
    }

    public CellInfoResponse getCellInfoByCellName(GetResponseByCellName request) {
            return globalResponseMapper.cellEntityToResponse(cellRepository.findByCellName(request.getCellName())
                    .orElseThrow(() -> new EntityNotFoundException("Камера не знайдена")));
    }
}
