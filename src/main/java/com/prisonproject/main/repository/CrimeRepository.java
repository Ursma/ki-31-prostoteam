package com.prisonproject.main.repository;

import com.prisonproject.main.entity.CrimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrimeRepository extends JpaRepository<CrimeEntity, Integer> {
    CrimeEntity findAllByCrimeNumber(String crimeNumbers);
}
