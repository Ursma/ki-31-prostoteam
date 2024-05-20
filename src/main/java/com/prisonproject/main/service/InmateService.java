package com.prisonproject.main.service;

import com.prisonproject.main.dto.request.AddInmateRequest;
import com.prisonproject.main.dto.request.GetResponseById;
import com.prisonproject.main.dto.response.InmateInfoResponse;
import com.prisonproject.main.dto.response.InmateInfoWithoutCellResponse;
import com.prisonproject.main.entity.CellEntity;
import com.prisonproject.main.entity.CrimeEntity;
import com.prisonproject.main.entity.InmateEntity;
import com.prisonproject.main.mapper.GlobalResponseMapper;
import com.prisonproject.main.repository.CellRepository;
import com.prisonproject.main.repository.CrimeRepository;
import com.prisonproject.main.repository.InmateRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InmateService {
    private final InmateRepository inmateRepository;
    private final CellRepository cellRepository;
    private final CrimeRepository crimeRepository;
    private final GlobalResponseMapper globalResponseMapper;
    public InmateEntity addInmateToCell(AddInmateRequest request){
        InmateEntity inmate = new InmateEntity();
        inmate.setBirthday(request.getBirthday());
        inmate.setEndDate(request.getEndDate());
        inmate.setGender(request.getGender());
        inmate.setCellId(request.getCellId());
        inmate.setStartDate(request.getStartDate());
        inmate.setName(request.getName());

            CellEntity cellEntity = cellRepository.findById(request.getCellId())
                    .orElseThrow(() -> new EntityNotFoundException("Камера не знайдена"));
        checkCellCapacity(cellEntity);
        inmate.setCellEntity(cellEntity);

            List<CrimeEntity> crimeEntityList = crimeRepository.findAllById(request.getCrimeIds());
        inmate.setCrimeEntityList(crimeEntityList);

        return inmateRepository.save(inmate);
    }

    private static void checkCellCapacity(CellEntity cellEntity) {
        Integer capacity = cellEntity.getCapacity();
        Integer currentOccupancy = cellEntity.getCurrentOccupancy();
        if(currentOccupancy < capacity){
            currentOccupancy++;
            cellEntity.setCurrentOccupancy(currentOccupancy);
        }   else throw new EntityNotFoundException("Камера заповнена!");
    }

    public InmateInfoResponse getInmateResponse(GetResponseById body){
        return globalResponseMapper.inmateEntityToResponse(inmateRepository.findById(body.getId())
                .orElseThrow(() -> new EntityNotFoundException("В'язня не знайдено")));
    }

    public InmateInfoWithoutCellResponse getShortInmateInfo(GetResponseById body) {
        return globalResponseMapper.inmateEntityToShortResponse(inmateRepository.findById(body.getId())
                .orElseThrow(() -> new EntityNotFoundException("В'язня не знайдено")));
    }

    public List<InmateInfoWithoutCellResponse> getShortInfoAboutAllInmates() {
        return inmateRepository.findAll().stream().map(globalResponseMapper::inmateEntityToShortResponse).toList();
    }

    public List<InmateInfoWithoutCellResponse> getAllInmatesByCell(GetResponseById body) {
        return inmateRepository.findAllByCellId(body.getId()).stream().map(globalResponseMapper::inmateEntityToShortResponse).toList();
    }
}
