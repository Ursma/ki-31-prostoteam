package com.prisonproject.main.repository;

import com.prisonproject.main.entity.EventLogsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<EventLogsEntity, Integer> {

    @Query(nativeQuery = true, value = "select * from event_log e where e.date >= :first and e.date <= :second")
    List<EventLogsEntity> findAllByPeriodOfTime(LocalDate first, LocalDate second);

    @Query(nativeQuery = true, value = "SELECT e.* FROM event_log e " +
            "INNER JOIN event_inmate ei ON e.id = ei.event_id " +
            "INNER JOIN inmate i ON i.id = ei.inmate_id " +
            "WHERE i.name LIKE :name AND e.date >= :first AND e.date <= :second")
    List<EventLogsEntity> findAllByPeriodOfTimeAndInmateName(LocalDate first, LocalDate second, String name);

    @Query(nativeQuery = true, value = "SELECT e.* FROM event_log e " +
            "INNER JOIN event_guard eg ON e.id = eg.event_id " +
            "INNER JOIN guard g ON g.id = eg.guard_id " +
            "WHERE g.name LIKE :name AND e.date >= :first AND e.date <= :second")
    List<EventLogsEntity> findAllByPeriodOfTimeAndGuardName(LocalDate first, LocalDate second, String name);

    @Query(nativeQuery = true, value = "SELECT e.* FROM event_log e " +
            "INNER JOIN event_inmate ei ON e.id = ei.event_id " +
            "INNER JOIN inmate i ON ei.inmate_id = i.id " +
            "WHERE i.name = :name")
    List<EventLogsEntity> findAllByInmateName(String name);

    @Query(nativeQuery = true, value = "SELECT e.* FROM event_log e " +
            "INNER JOIN event_guard eg ON e.id = eg.event_id " +
            "INNER JOIN guard g ON eg.guard_id = g.id " +
            "WHERE g.name = :name")
    List<EventLogsEntity> findAllByGuardName(String name);

}
