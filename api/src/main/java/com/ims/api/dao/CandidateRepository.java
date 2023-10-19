package com.ims.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ims.api.entities.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
