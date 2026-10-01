package com.campus.eventmanagement.service;


import java.util.List;

import com.campus.eventmanagement.model.Event;

public interface EventService {

    Event insert(Event event);

    Event search(Long id);
    
    Event update(Event event);

    List<Event> getAll();
    void delete(Long id);
}