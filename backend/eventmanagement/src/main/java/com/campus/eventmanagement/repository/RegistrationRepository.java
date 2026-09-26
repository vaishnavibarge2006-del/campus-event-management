package com.campus.eventmanagement.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campus.eventmanagement.model.Registration;

@Repository
@Qualifier("registrationRepo")
public interface RegistrationRepository extends JpaRepository<Registration, Long> {

}