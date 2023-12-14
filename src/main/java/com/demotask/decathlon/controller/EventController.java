package com.demotask.decathlon.controller;

import com.demotask.decathlon.dto.EventDTO;
import com.demotask.decathlon.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService eventService;

    public EventController(){
    }

    @GetMapping()
    public List<EventDTO> getAll() {
        return eventService.getAllDTOs();
    }
}