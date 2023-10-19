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

import com.ims.api.entities.Interview;
import com.ims.api.services.InterviewService;

@RestController
@RequestMapping("/api/interviews")
public class InterviewController {
    
    @Autowired
    private final InterviewService interviewService;

    
    public InterviewController(InterviewService interviewService) {
        this.interviewService = interviewService;
    }

    @GetMapping
    public List<Interview> getAllInterviews() {
        return interviewService.getAllInterviews();
    }

    @GetMapping("/{interviewID}")
    public ResponseEntity<Interview> getInterviewById(@PathVariable Long interviewID) {
        Optional<Interview> interview = interviewService.getInterviewById(interviewID);
        return interview.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Interview> createInterview(@RequestBody Interview interview) {
        Interview createdInterview = interviewService.createInterview(interview);
        return ResponseEntity.ok(createdInterview);
    }

    @PutMapping("/{interviewID}")
    public ResponseEntity<Interview> updateInterview(@PathVariable Long interviewID,@RequestBody Interview updatedInterview) {
        Interview interview = interviewService.updateInterview(interviewID, updatedInterview);
        return interview != null ? ResponseEntity.ok(interview) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{interviewID}")
    public ResponseEntity<Void> deleteInterview(@PathVariable Long interviewID) {
        interviewService.deleteInterview(interviewID);
        return ResponseEntity.noContent().build();
    }
}
