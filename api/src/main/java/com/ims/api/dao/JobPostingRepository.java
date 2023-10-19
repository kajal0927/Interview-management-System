package com.ims.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ims.api.entities.JobPosting;

public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {
    
}