package com.campus.eventmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.campus.eventmanagement.model.Registration;
import com.campus.eventmanagement.service.RegistrationService;

@RestController
@RequestMapping("/api/registrations")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    // Get all registrations
    @GetMapping
    public List<Registration> getAllRegistrations() {
        return registrationService.getAll();
    }

    // Get registration by ID
    @GetMapping("/{id}")
    public ResponseEntity<Registration> getRegistrationById(
            @PathVariable Long id) {

        Registration registration =
                registrationService.search(id);

        if (registration != null) {
            return ResponseEntity.ok(registration);
        }

        return ResponseEntity.notFound().build();
    }

    // Add registration
    @PostMapping
    public Registration addRegistration(
            @RequestBody Registration registration) {

        return registrationService.insert(registration);
    }

    // Update registration
    @PutMapping("/{id}")
    public ResponseEntity<Registration> updateRegistration(
            @PathVariable Long id,
            @RequestBody Registration registration) {

        registration.setRegistrationId(id);

        Registration updatedRegistration =
                registrationService.update(registration);

        if (updatedRegistration != null) {
            return ResponseEntity.ok(updatedRegistration);
        }

        return ResponseEntity.notFound().build();
    }
}