package com.campus.eventmanagement.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.campus.eventmanagement.model.Event;
import com.campus.eventmanagement.service.EventService;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    // Get all events
    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAll();
    }

    // Get event by ID
    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {

        Event event = eventService.search(id);

        if (event != null) {
            return ResponseEntity.ok(event);
        }

        return ResponseEntity.notFound().build();
    }

    // Add event
    @PostMapping
    public Event addEvent(@RequestBody Event event) {
        return eventService.insert(event);
    }

    // Update event
    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(
            @PathVariable Long id,
            @RequestBody Event event) {

        event.setId(id);

        Event updatedEvent = eventService.update(event);

        if (updatedEvent != null) {
            return ResponseEntity.ok(updatedEvent);
        }

        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long id) {

        Event event = eventService.search(id);

        if (event != null) {
            eventService.delete(id);
            return ResponseEntity.ok("Event deleted successfully");
        }

        return ResponseEntity.notFound().build();
    }
}