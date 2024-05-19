package com.prisonproject.main.service;

import com.prisonproject.main.dto.AddCrimeRequest;
import com.prisonproject.main.entity.CrimeEntity;
import com.prisonproject.main.repository.CrimeRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CrimeService {
    private final CrimeRepository crimeRepository;

    public void addCrime(AddCrimeRequest request){
        CrimeEntity entity = new CrimeEntity();
        entity.setCrimeNumber(request.getCrimeNumber());
        entity.setDurability(request.getDurability());
        crimeRepository.save(entity);
    }
}
