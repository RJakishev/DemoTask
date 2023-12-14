package com.demotask.decathlon.service;

import com.demotask.decathlon.dto.EventDTO;
import com.demotask.decathlon.model.Event;
import com.demotask.decathlon.repository.EventRepository;
import com.demotask.decathlon.util.factory.EventFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventFactory eventFactory;

    @Autowired
    private EventRepository eventRepository;

    public Event getById(int id) { return eventRepository.findById(id).orElse(null); }

    public List<EventDTO> getAllDTOs() { return eventFactory.toDto(getAll()); }

    public List<Event> getAll() { return eventRepository.findAll(); }
}
