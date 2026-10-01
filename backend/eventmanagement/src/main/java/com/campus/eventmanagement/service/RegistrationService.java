package com.campus.eventmanagement.service;

import java.util.List;

import com.campus.eventmanagement.model.Registration;

public interface RegistrationService {

    Registration insert(Registration registration);

    Registration search(Long id);

    Registration update(Registration registration);

    List<Registration> getAll();
}