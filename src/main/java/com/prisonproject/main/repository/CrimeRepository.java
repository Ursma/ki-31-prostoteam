package com.prisonproject.main.repository;

import com.prisonproject.main.entity.CrimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrimeRepository extends JpaRepository<CrimeEntity, Integer> {
}
