package com.campus.eventmanagement.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campus.eventmanagement.model.Category;

@Repository
@Qualifier("categoryRepo")
public interface CategoryRepository extends JpaRepository<Category, Long> {

}