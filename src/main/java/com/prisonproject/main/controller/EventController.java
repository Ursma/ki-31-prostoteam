package com.prisonproject.main.controller;

import com.prisonproject.main.dto.request.AddEventRequest;
import com.prisonproject.main.dto.request.GetEventByPeriodOfTimeAndName;
import com.prisonproject.main.dto.request.GetEventByPeriodOfTimeRequest;
import com.prisonproject.main.dto.response.EventInfoResponse;
import com.prisonproject.main.entity.EventLogsEntity;
import com.prisonproject.main.service.EventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/event")
@Tag(name = "Запити для роботи з подіями")
public class EventController {
    private final EventService eventService;

    @PutMapping("/add")
    @Operation(summary = "Додати нову подію", description = "Додає подію яка відбулась у в'язниці")
    public EventLogsEntity addEvent(@RequestBody AddEventRequest request){
        return eventService.addEvent(request);
    }

    @PostMapping("/get/all")
    public List<EventInfoResponse> getAllEventByPeriodOfTime(@RequestBody GetEventByPeriodOfTimeRequest request){
        return eventService.getEventsByByPeriodOfTime(request.getFirst(), request.getSecond());
    }

    @PostMapping("/get/all/by/inmate")
        public List<EventInfoResponse> getAllEventByPeriodOfTimeAndInmate(@RequestBody GetEventByPeriodOfTimeAndName request){
        return eventService.getEventsByByPeriodOfTimeAndInmateName(request.getFirst(), request.getSecond(), request.getName());
    }
    @PostMapping("/get/all/by/guard")
    public List<EventInfoResponse> getAllEventByPeriodOfTimeAndGuard(@RequestBody GetEventByPeriodOfTimeAndName request){
        return eventService.getEventsByByPeriodOfTimeAndGuardName(request.getFirst(), request.getSecond(), request.getName());
    }
}
