package com.prisonproject.main.repository;

import com.prisonproject.main.entity.CellEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CellRepository extends JpaRepository<CellEntity, Integer> {
}
