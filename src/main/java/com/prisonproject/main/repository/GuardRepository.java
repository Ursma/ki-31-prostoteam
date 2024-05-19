package com.prisonproject.main.repository;

import com.prisonproject.main.entity.GuardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuardRepository extends JpaRepository<GuardEntity, Integer> {
    List<GuardEntity> findAllByCellId(Integer id);
}
