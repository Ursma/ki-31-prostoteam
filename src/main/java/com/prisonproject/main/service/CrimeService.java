package com.prisonproject.main.service;

import com.prisonproject.main.dto.request.AddCrimeRequest;
import com.prisonproject.main.entity.CrimeEntity;
import com.prisonproject.main.repository.CrimeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CrimeService {
    private final CrimeRepository crimeRepository;

    public CrimeEntity addCrime(AddCrimeRequest request){
        CrimeEntity entity = new CrimeEntity();
        entity.setCrimeNumber(request.getCrimeNumber());
        entity.setDurability(request.getDurability());
        return crimeRepository.save(entity);
    }
}
