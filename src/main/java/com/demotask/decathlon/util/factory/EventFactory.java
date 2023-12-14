package com.demotask.decathlon.util.factory;

import com.demotask.decathlon.dto.EventDTO;
import com.demotask.decathlon.model.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EventFactory {

    private static final Logger log = LoggerFactory.getLogger(EventFactory.class);

    public EventFactory(){
    }

    public EventDTO toDto(Event event) {

        if (event == null) {
            return null;
        }

        log.debug("Converting Event entity to DTO.");

        EventDTO eventDTO = new EventDTO();

        eventDTO.setId(event.getId());
        if(event.getName() != null) eventDTO.setName(event.getName());

        return eventDTO;
    }

    public List<EventDTO> toDto(List<Event> events){

        List<EventDTO> eventDTOs = new ArrayList<>();

        for (Event event : events) {
            eventDTOs.add(toDto(event));
        }

        return eventDTOs;
    }
}
