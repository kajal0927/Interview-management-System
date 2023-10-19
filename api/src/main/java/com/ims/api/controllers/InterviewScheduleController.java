package com.ims.api.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ims.api.entities.InterviewSchedule;
import com.ims.api.services.InterviewScheduleService;

@RestController
@RequestMapping("/api/interview-schedules")
public class InterviewScheduleController {

    @Autowired
    private final InterviewScheduleService interviewScheduleService;

    
    public InterviewScheduleController(InterviewScheduleService interviewScheduleService) {
        this.interviewScheduleService = interviewScheduleService;
    }

    @GetMapping
    public List<InterviewSchedule> getAllInterviewSchedules() {
        return interviewScheduleService.getAllInterviewSchedules();
    }

    @GetMapping("/{scheduleID}")
    public ResponseEntity<InterviewSchedule> getInterviewScheduleById(@PathVariable Long scheduleID) {
        Optional<InterviewSchedule> interviewSchedule = interviewScheduleService.getInterviewScheduleById(scheduleID);
        return interviewSchedule.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<InterviewSchedule> createInterviewSchedule(@RequestBody InterviewSchedule interviewSchedule) {
        InterviewSchedule createdInterviewSchedule = interviewScheduleService.createInterviewSchedule(interviewSchedule);
        return ResponseEntity.ok(createdInterviewSchedule);
    }

    @PutMapping("/{scheduleID}")
    public ResponseEntity<InterviewSchedule> updateInterviewSchedule(@PathVariable Long scheduleID,
                                                                    @RequestBody InterviewSchedule updatedInterviewSchedule) {
        InterviewSchedule interviewSchedule = interviewScheduleService.updateInterviewSchedule(scheduleID, updatedInterviewSchedule);
        return interviewSchedule != null ? ResponseEntity.ok(interviewSchedule) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{scheduleID}")
    public ResponseEntity<Void> deleteInterviewSchedule(@PathVariable Long scheduleID) {
        interviewScheduleService.deleteInterviewSchedule(scheduleID);
        return ResponseEntity.noContent().build();
    }
}
