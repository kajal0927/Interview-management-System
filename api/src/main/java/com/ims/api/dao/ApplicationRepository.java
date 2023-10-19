package com.ims.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ims.api.entities.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long>{
    
}