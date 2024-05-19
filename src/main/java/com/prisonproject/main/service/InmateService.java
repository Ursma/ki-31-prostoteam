package com.prisonproject.main.service;

import com.prisonproject.main.dto.AddInmateRequest;
import com.prisonproject.main.entity.CellEntity;
import com.prisonproject.main.entity.CrimeEntity;
import com.prisonproject.main.entity.InmateEntity;
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
    public InmateEntity addInmateToCell(AddInmateRequest request){
        InmateEntity inmate = new InmateEntity();
        inmate.setBirthday(request.getBirthday());
        inmate.setEndDate(request.getEndDate());
        inmate.setGender(request.getGender());
        inmate.setCellId(request.getCellId());
        inmate.setStartDate(request.getStartDate());
        inmate.setName(request.getName());
            CellEntity cellEntity = cellRepository.findById(request.getCellId())
                    .orElseThrow(() -> new EntityNotFoundException("Cell not found"));
            inmate.setCellEntity(cellEntity);

            List<CrimeEntity> crimeEntityList = crimeRepository.findAllById(request.getCrimeIds());
        inmate.setCrimeEntityList(crimeEntityList);

        return inmateRepository.save(inmate);
    }
}
