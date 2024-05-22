package com.prisonproject.main.controller;

import com.prisonproject.main.dto.request.AddEventRequest;
import com.prisonproject.main.entity.EventLogsEntity;
import com.prisonproject.main.service.EventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
