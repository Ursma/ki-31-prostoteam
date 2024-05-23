package com.prisonproject.main.service;

import com.prisonproject.main.dto.request.AddEventRequest;
import com.prisonproject.main.dto.response.EventInfoResponse;
import com.prisonproject.main.entity.CellEntity;
import com.prisonproject.main.entity.EventLogsEntity;
import com.prisonproject.main.entity.GuardEntity;
import com.prisonproject.main.entity.InmateEntity;
import com.prisonproject.main.enums.EventTypeEnum;
import com.prisonproject.main.mapper.GlobalResponseMapper;
import com.prisonproject.main.repository.CellRepository;
import com.prisonproject.main.repository.EventRepository;
import com.prisonproject.main.repository.GuardRepository;
import com.prisonproject.main.repository.InmateRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final InmateRepository inmateRepository;
    private final GuardRepository guardRepository;
    private final GlobalResponseMapper globalResponseMapper;
    private final CellRepository cellRepository;

    public EventLogsEntity addEvent(AddEventRequest request) {
        List<InmateEntity> inmates = new ArrayList<>();
        Integer durability = EventTypeEnum.getDurabilityByEventNumber(request.getEventNumber());
                request.getInmateNames().forEach(n -> inmates.add(inmateRepository.findByNameContainingIgnoreCase(n)
                        .orElseThrow(() -> new EntityNotFoundException("В'язня з іменем " + n + " не знайдено"))));
                inmates.forEach(i -> {
                    if(request.getEventNumber() == 4){
                        CellEntity cell = cellRepository.findByCellName("Медпункт")
                                .orElseThrow(() -> new EntityNotFoundException("Камеру не знайдено"));
                        cell.setCurrentOccupancy(cell.getCurrentOccupancy() + 1);
                        i.setCellEntity(cell);
                        i.setCellId(cell.getId());
                    }
                    i.setEndDate(i.getEndDate().plusYears(durability));
                    inmateRepository.save(i);
                });
        List<GuardEntity> guards;
        if(request.getEventNumber() == 6){
            guards = Collections.emptyList();
        }else {
            guards = new ArrayList<>();
            request.getGuardNames().forEach(g -> guards.add(guardRepository.findByNameContainingIgnoreCase(g)
                    .orElseThrow(() -> new EntityNotFoundException("Охоронця з іменем " + g + " не знайдено"))));
        }

        EventLogsEntity entity = new EventLogsEntity();
        entity.setInmateEntityList(inmates);
        entity.setGuardEntityList(guards);
        entity.setEventType(request.getEventNumber());
        entity.setDate(request.getDate());
        return eventRepository.save(entity);
    }


    public List<EventInfoResponse> getEventsByByPeriodOfTime(LocalDate first, LocalDate second){
        return  globalResponseMapper.eventEntitiesToResponse(eventRepository.findAllByPeriodOfTime(first, second));
    }

    public List<EventInfoResponse> getEventsByByPeriodOfTimeAndInmateName(LocalDate first, LocalDate second, String name){
        if(first != null && second != null){
            return  globalResponseMapper.eventEntitiesToResponse(eventRepository.findAllByPeriodOfTimeAndInmateName(first, second, name));
        } else {
            return globalResponseMapper.eventEntitiesToResponse(eventRepository.findAllByInmateName(name));
        }
    }

    public List<EventInfoResponse> getEventsByByPeriodOfTimeAndGuardName(LocalDate first, LocalDate second, String name){
        if(first != null && second != null){
            return  globalResponseMapper.eventEntitiesToResponse(eventRepository.findAllByPeriodOfTimeAndGuardName(first, second, name));
        }else{
            return  globalResponseMapper.eventEntitiesToResponse(eventRepository.findAllByGuardName(name));
        }

    }
}
