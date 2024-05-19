package com.prisonproject.main.repository;

import com.prisonproject.main.entity.InmateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InmateRepository extends JpaRepository<InmateEntity, Integer> {
}
