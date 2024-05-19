package com.prisonproject.main.service;

import com.prisonproject.main.dto.request.AddGuardRequest;
import com.prisonproject.main.entity.CellEntity;
import com.prisonproject.main.entity.GuardEntity;
import com.prisonproject.main.repository.CellRepository;
import com.prisonproject.main.repository.GuardRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GuardService {
    private final GuardRepository guardRepository;
    private final CellRepository cellRepository;

    public GuardEntity addGuard(AddGuardRequest request){
        GuardEntity guardEntity = new GuardEntity();
        guardEntity.setBirthday(request.getBirthday());
        guardEntity.setName(request.getName());
        guardEntity.setStartDate(request.getStartDate());
        guardEntity.setGender(request.getGender());
        guardEntity.setShift(request.getShift());
        guardEntity.setCellId(request.getCellId());
        CellEntity cellEntity = cellRepository.findById(request.getCellId())
                .orElseThrow(() -> new EntityNotFoundException("Камера не знайдена"));
        guardEntity.setCellEntity(cellEntity);
        return guardRepository.save(guardEntity);
    }


}
