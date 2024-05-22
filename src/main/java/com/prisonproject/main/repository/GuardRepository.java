package com.prisonproject.main.repository;

import com.prisonproject.main.entity.CellEntity;
import com.prisonproject.main.entity.GuardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GuardRepository extends JpaRepository<GuardEntity, Integer> {
    Optional<GuardEntity> findByNameContainingIgnoreCase(String name);
    List<GuardEntity> findAllByCellEntity(CellEntity cell);

    Boolean existsInmateEntityByName(String name);

}
