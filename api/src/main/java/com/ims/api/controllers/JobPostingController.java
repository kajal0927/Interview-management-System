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

import com.ims.api.entities.JobPosting;
import com.ims.api.services.JobPostingService;

@RestController
@RequestMapping("/api/jobpostings")
public class JobPostingController {

    @Autowired
    private final JobPostingService jobPostingService;

    public JobPostingController(JobPostingService jobPostingService) {
        this.jobPostingService = jobPostingService;
    }

    @GetMapping
    public List<JobPosting> getAllJobPostings() {
        return jobPostingService.getAllJobPostings();
    }

    @GetMapping("/{jobId}")
    public ResponseEntity<JobPosting> getJobPostingById(@PathVariable Long jobId) {
        Optional<JobPosting> jobPosting = jobPostingService.getJobPostingById(jobId);
        return jobPosting.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<JobPosting> createJobPosting(@RequestBody JobPosting jobPosting) {
        JobPosting createdJobPosting = jobPostingService.createJobPosting(jobPosting);
        return ResponseEntity.ok(createdJobPosting);
    }

    @PutMapping("/{jobId}")
    public ResponseEntity<JobPosting> updateJobPosting(@PathVariable Long jobId, @RequestBody JobPosting updatedJobPosting) {
        JobPosting jobPosting = jobPostingService.updateJobPosting(jobId, updatedJobPosting);
        return jobPosting != null ? ResponseEntity.ok(jobPosting) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{jobId}")
    public ResponseEntity<Void> deleteJobPosting(@PathVariable Long jobId) {
        jobPostingService.deleteJobPosting(jobId);
        return ResponseEntity.noContent().build();
    }
}
