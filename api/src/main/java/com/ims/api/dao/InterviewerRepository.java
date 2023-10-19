package com.ims.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ims.api.entities.Interviewer;

public interface InterviewerRepository extends JpaRepository<Interviewer, Long> {
    
}
