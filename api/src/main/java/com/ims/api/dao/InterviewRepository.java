package com.ims.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ims.api.entities.Interview;

public interface InterviewRepository extends JpaRepository<Interview, Long> {
    
}


