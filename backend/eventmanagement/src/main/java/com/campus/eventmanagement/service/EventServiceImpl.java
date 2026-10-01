package com.campus.eventmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campus.eventmanagement.model.Event;
import com.campus.eventmanagement.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event insert(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event search(Long id) {

        Event event = eventRepository.findById(id).orElse(null);

        return event;
    }

    @Override
    public Event update(Event event) {

        Event existingEvent =
                eventRepository.findById(event.getId()).orElse(null);

        if (existingEvent != null) {

            existingEvent.setEventName(event.getEventName());
            existingEvent.setDescription(event.getDescription());
            existingEvent.setEventDate(event.getEventDate());
            existingEvent.setVenue(event.getVenue());
            existingEvent.setCategory(event.getCategory());
            existingEvent.setCapacity(event.getCapacity());

            return eventRepository.save(existingEvent);
        }

        return null;
    }

    @Override
    public List<Event> getAll() {
        return eventRepository.findAll();
    }
    @Override
    public void delete(Long id) {

        Event event = eventRepository.findById(id).orElse(null);

        if (event != null) {
            eventRepository.delete(event);
        }
    }
}