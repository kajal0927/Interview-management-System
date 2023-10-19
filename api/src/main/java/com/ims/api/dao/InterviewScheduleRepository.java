package com.ims.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ims.api.entities.InterviewSchedule;

public interface InterviewScheduleRepository extends JpaRepository<InterviewSchedule, Long> {
}
