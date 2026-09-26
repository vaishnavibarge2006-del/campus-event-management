package com.campus.eventmanagement.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campus.eventmanagement.model.User;

@Repository
@Qualifier("userRepo")
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}