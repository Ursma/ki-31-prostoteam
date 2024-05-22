package com.prisonproject.main.service;

import com.prisonproject.main.dto.request.AddCrimeRequest;
import com.prisonproject.main.dto.response.CrimeInfoResponse;
import com.prisonproject.main.entity.CrimeEntity;
import com.prisonproject.main.mapper.GlobalResponseMapper;
import com.prisonproject.main.repository.CrimeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CrimeService {
    private final CrimeRepository crimeRepository;
    private final GlobalResponseMapper globalResponseMapper;

    public CrimeEntity addCrime(AddCrimeRequest request){
        CrimeEntity entity = new CrimeEntity();
        entity.setCrimeNumber(request.getCrimeNumber());
        entity.setDurability(request.getDurability());
        return crimeRepository.save(entity);
    }

    public List<CrimeInfoResponse> getAllCrimes() {
        return globalResponseMapper.crimeEntitiesToResponse(crimeRepository.findAll());
    }
}
