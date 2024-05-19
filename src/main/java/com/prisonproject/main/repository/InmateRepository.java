package com.prisonproject.main.repository;

import com.prisonproject.main.entity.InmateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InmateRepository extends JpaRepository<InmateEntity, Integer> {
    List<InmateEntity> findAllByCellId(Integer id);
}
