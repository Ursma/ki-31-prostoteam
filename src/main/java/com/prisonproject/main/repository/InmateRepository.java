package com.prisonproject.main.repository;
import com.prisonproject.main.entity.CellEntity;
import com.prisonproject.main.entity.InmateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface InmateRepository extends JpaRepository<InmateEntity, Integer> {
    List<InmateEntity> findAllByCellEntity(CellEntity cell);

    Optional<InmateEntity> findByNameContainingIgnoreCase(String name);

    Boolean existsInmateEntityByName(String name);


}
