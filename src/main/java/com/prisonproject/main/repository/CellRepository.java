package com.prisonproject.main.repository;

import com.prisonproject.main.entity.CellEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CellRepository extends JpaRepository<CellEntity, Integer> {
    Optional<CellEntity> findByCellName(String name);

    Boolean existsCellEntityByCellName(String cellName);
}
