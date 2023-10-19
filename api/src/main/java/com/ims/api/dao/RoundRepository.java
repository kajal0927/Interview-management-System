package com.ims.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ims.api.entities.Round;

public interface RoundRepository extends JpaRepository<Round, Long> {
    
}
