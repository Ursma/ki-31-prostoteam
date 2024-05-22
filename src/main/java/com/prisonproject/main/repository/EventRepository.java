package com.prisonproject.main.repository;

import com.prisonproject.main.entity.EventLogsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<EventLogsEntity, Integer> {

}
