package com.prisonproject.main.service;

import com.prisonproject.main.dto.request.AddGuardRequest;
import com.prisonproject.main.dto.request.GetResponseByCellName;
import com.prisonproject.main.dto.request.GetResponseByName;
import com.prisonproject.main.dto.response.GuardInfoResponse;
import com.prisonproject.main.dto.response.GuardInfoWithoutCellResponse;
import com.prisonproject.main.entity.CellEntity;
import com.prisonproject.main.entity.GuardEntity;
import com.prisonproject.main.mapper.GlobalResponseMapper;
import com.prisonproject.main.repository.CellRepository;
import com.prisonproject.main.repository.GuardRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GuardService {
    private final GuardRepository guardRepository;
    private final CellRepository cellRepository;
    private final GlobalResponseMapper globalResponseMapper;

    public GuardEntity addGuard(AddGuardRequest request){
        checkIsValidName(request.getName());
        GuardEntity guardEntity = new GuardEntity();
        guardEntity.setBirthday(request.getBirthday());
        guardEntity.setName(request.getName());
        guardEntity.setStartDate(request.getStartDate());
        guardEntity.setGender(request.getGender());
        guardEntity.setShift(request.getShift());

        CellEntity cellEntity = cellRepository.findByCellName(request.getCellName())
                .orElseThrow(() -> new EntityNotFoundException("Камера не знайдена"));
        guardEntity.setCellEntity(cellEntity);
        guardEntity.setCellId(cellEntity.getId());
        return guardRepository.save(guardEntity);
    }

    public GuardInfoResponse getGuardInfo(GetResponseByName body){
        return globalResponseMapper.guardEntityToResponse(guardRepository.findByNameContainingIgnoreCase(body.getName())
                .orElseThrow(() -> new EntityNotFoundException("Охоронника не знайдено")));
    }

    public GuardInfoWithoutCellResponse getShortGuardInfo(GetResponseByName body){
        return globalResponseMapper.guardEntityToShortInfoResponse(guardRepository.findByNameContainingIgnoreCase(body.getName())
                .orElseThrow(() -> new EntityNotFoundException("Охоронника не знайдено")));
    }

    public List<GuardInfoWithoutCellResponse> getShortInfoAboutAllGuards(){
        return guardRepository.findAll()
                .stream()
                .map(globalResponseMapper::guardEntityToShortInfoResponse)
                .toList();
    }

    public List<GuardInfoWithoutCellResponse> getAllGuardsByCell(GetResponseByCellName body) {
        CellEntity cell = cellRepository.findByCellName(body.getCellName())
                .orElseThrow(() -> new EntityNotFoundException("Камера не знайдена"));
        return guardRepository.findAllByCellEntity(cell)
                .stream()
                .map(globalResponseMapper::guardEntityToShortInfoResponse)
                .toList();
    }

    private void checkIsValidName(String name) {
        if(Boolean.TRUE.equals(guardRepository.existsInmateEntityByName(name))) throw new EntityExistsException("Охоронець з таким ім'ям вже існує");
    }
}
