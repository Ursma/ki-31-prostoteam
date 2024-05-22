package com.prisonproject.main.service;

import com.prisonproject.main.dto.request.AddInmateRequest;
import com.prisonproject.main.dto.request.GetResponseByCellName;
import com.prisonproject.main.dto.request.GetResponseByName;
import com.prisonproject.main.dto.response.InmateInfoResponse;
import com.prisonproject.main.dto.response.InmateInfoWithoutCellResponse;
import com.prisonproject.main.entity.CellEntity;
import com.prisonproject.main.entity.CrimeEntity;
import com.prisonproject.main.entity.InmateEntity;
import com.prisonproject.main.mapper.GlobalResponseMapper;
import com.prisonproject.main.repository.CellRepository;
import com.prisonproject.main.repository.CrimeRepository;
import com.prisonproject.main.repository.InmateRepository;
import jakarta.persistence.EntityExistsException;
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
        checkIsValidName(request.getName());
        InmateEntity inmate = new InmateEntity();
        inmate.setBirthday(request.getBirthday());
        inmate.setGender(request.getGender());
        inmate.setStartDate(request.getStartDate());
        inmate.setName(request.getName());

            CellEntity cellEntity = cellRepository.findByCellName(request.getCellName())
                    .orElseThrow(() -> new EntityNotFoundException("Камера не знайдена"));
        checkCellCapacity(cellEntity);
        inmate.setCellEntity(cellEntity);
        inmate.setCellId(cellEntity.getId());
            List<CrimeEntity> crimeEntityList = request.getCrimeNumbers()
                    .stream()
                    .map(crimeRepository::findAllByCrimeNumber)
                    .toList();
        inmate.setCrimeEntityList(crimeEntityList);
        Integer years = 0;
        for (CrimeEntity crimeEntity : crimeEntityList) {
            years += crimeEntity.getDurability();
        }
        inmate.setEndDate(request.getStartDate().plusYears(years));
        return inmateRepository.save(inmate);
    }

    private void checkIsValidName(String name) {
        if(Boolean.TRUE.equals(inmateRepository.existsInmateEntityByName(name))) throw new EntityExistsException("В'язень з таким ім'ям вже існує");
    }

    private static void checkCellCapacity(CellEntity cellEntity) {
        Integer capacity = cellEntity.getCapacity();
        Integer currentOccupancy = cellEntity.getCurrentOccupancy();
        if(currentOccupancy < capacity){
            currentOccupancy++;
            cellEntity.setCurrentOccupancy(currentOccupancy);
        }   else throw new EntityNotFoundException("Камера заповнена!");
    }

    public InmateInfoResponse getInmateResponse(GetResponseByName body){
        return globalResponseMapper.inmateEntityToResponse(inmateRepository.findByNameContainingIgnoreCase(body.getName())
                .orElseThrow(() -> new EntityNotFoundException("В'язня не знайдено")));
    }

    public InmateInfoWithoutCellResponse getShortInmateInfo(GetResponseByName body) {
        return globalResponseMapper.inmateEntityToShortResponse(inmateRepository.findByNameContainingIgnoreCase(body.getName())
                .orElseThrow(() -> new EntityNotFoundException("В'язня не знайдено")));
    }

    public List<InmateInfoWithoutCellResponse> getShortInfoAboutAllInmates() {
        return inmateRepository.findAll().stream().map(globalResponseMapper::inmateEntityToShortResponse).toList();
    }

    public List<InmateInfoWithoutCellResponse> getAllInmatesByCell(GetResponseByCellName body) {
        CellEntity cell = cellRepository.findByCellName(body.getCellName()).orElseThrow(() -> new EntityNotFoundException("Камера не знайдена"));;
        return inmateRepository.findAllByCellEntity(cell).stream().map(globalResponseMapper::inmateEntityToShortResponse).toList();
    }
}
