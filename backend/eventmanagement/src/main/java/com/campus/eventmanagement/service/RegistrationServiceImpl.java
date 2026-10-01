package com.campus.eventmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campus.eventmanagement.model.Registration;
import com.campus.eventmanagement.repository.RegistrationRepository;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Override
    public Registration insert(Registration registration) {
        return registrationRepository.save(registration);
    }

    @Override
    public Registration search(Long id) {

        Registration registration =
                registrationRepository.findById(id).orElse(null);

        return registration;
    }

    @Override
    public Registration update(Registration registration) {

        Registration existingRegistration =
                registrationRepository.findById(
                        registration.getRegistrationId()
                ).orElse(null);

        if (existingRegistration != null) {

            existingRegistration.setUserId(registration.getUserId());
            existingRegistration.setEventId(registration.getEventId());
            existingRegistration.setRegistrationDate(
                    registration.getRegistrationDate()
            );
            existingRegistration.setStatus(registration.getStatus());

            return registrationRepository.save(existingRegistration);
        }

        return null;
    }

    @Override
    public List<Registration> getAll() {
        return registrationRepository.findAll();
    }
}