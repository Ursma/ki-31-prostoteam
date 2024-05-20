package com.prisonproject.main.service;

import com.prisonproject.main.dto.request.AddGuardRequest;
import com.prisonproject.main.dto.request.GetResponseById;
import com.prisonproject.main.dto.response.GuardInfoResponse;
import com.prisonproject.main.dto.response.GuardInfoWithoutCellResponse;
import com.prisonproject.main.entity.CellEntity;
import com.prisonproject.main.entity.GuardEntity;
import com.prisonproject.main.mapper.GlobalResponseMapper;
import com.prisonproject.main.repository.CellRepository;
import com.prisonproject.main.repository.GuardRepository;
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

    public GuardInfoResponse getGuardInfo(GetResponseById body){
        return globalResponseMapper.guardEntityToResponse(guardRepository.findById(body.getId())
                .orElseThrow(() -> new EntityNotFoundException("Охоронника не знайдено")));
    }

    public GuardInfoWithoutCellResponse getShortGuardInfo(GetResponseById body){
        return globalResponseMapper.guardEntityToShortInfoResponse(guardRepository.findById(body.getId())
                .orElseThrow(() -> new EntityNotFoundException("Охоронника не знайдено")));
    }

    public List<GuardInfoWithoutCellResponse> getShortInfoAboutAllGuards(){
        return guardRepository.findAll()
                .stream()
                .map(globalResponseMapper::guardEntityToShortInfoResponse)
                .toList();
    }

    public List<GuardInfoWithoutCellResponse> getAllGuardsByCell(GetResponseById body) {
        return guardRepository.findAllByCellId(body.getId())
                .stream()
                .map(globalResponseMapper::guardEntityToShortInfoResponse)
                .toList();
    }
}
