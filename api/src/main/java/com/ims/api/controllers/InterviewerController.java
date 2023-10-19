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

import com.ims.api.entities.Interviewer;
import com.ims.api.services.InterviewerService;

@RestController
@RequestMapping("/api/interviewers")
public class InterviewerController {

    @Autowired
    private final InterviewerService interviewerService;

    public InterviewerController(InterviewerService interviewerService) {
        this.interviewerService = interviewerService;
    }

    @GetMapping
    public List<Interviewer> getAllInterviewers() {
        return interviewerService.getAllInterviewers();
    }

    @GetMapping("/{interviewerId}")
    public ResponseEntity<Interviewer> getInterviewerById(@PathVariable Long interviewerId) {
        Optional<Interviewer> interviewer = interviewerService.getInterviewerById(interviewerId);
        return interviewer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Interviewer> createInterviewer(@RequestBody Interviewer interviewer) {
        Interviewer createdInterviewer = interviewerService.createInterviewer(interviewer);
        return ResponseEntity.ok(createdInterviewer);
    }

    @PutMapping("/{interviewerId}")
    public ResponseEntity<Interviewer> updateInterviewer(@PathVariable Long interviewerId,@RequestBody Interviewer updatedInterviewer) {
        Interviewer interviewer = interviewerService.updateInterviewer(interviewerId, updatedInterviewer);
        return interviewer != null ? ResponseEntity.ok(interviewer) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{interviewerId}")
    public ResponseEntity<Void> deleteInterviewer(@PathVariable Long interviewerId) {
        interviewerService.deleteInterviewer(interviewerId);
        return ResponseEntity.noContent().build();
    }
}
