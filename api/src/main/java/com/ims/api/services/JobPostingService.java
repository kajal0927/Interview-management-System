package com.ims.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ims.api.dao.JobPostingRepository;
import com.ims.api.entities.JobPosting;

@Service
public class JobPostingService {

    @Autowired
    private  JobPostingRepository jobPostingRepository;

    public JobPostingService(JobPostingRepository jobPostingRepository) {
        this.jobPostingRepository = jobPostingRepository;
    }

    public List<JobPosting> getAllJobPostings() {
        return jobPostingRepository.findAll();
    }

    public Optional<JobPosting> getJobPostingById(Long jobId) {
        return jobPostingRepository.findById(jobId);
    }

    public JobPosting createJobPosting(JobPosting jobPosting) {
        
        return jobPostingRepository.save(jobPosting);
    }

    public JobPosting updateJobPosting(Long jobId, JobPosting updatedJobPosting) {
        return jobPostingRepository.findById(jobId)
                .map(jobPosting -> {
                    jobPosting.setTitle(updatedJobPosting.getTitle());
                    jobPosting.setDescription(updatedJobPosting.getDescription());
                    jobPosting.setDepartment(updatedJobPosting.getDepartment());
                    jobPosting.setSkills(updatedJobPosting.getSkills());
                    jobPosting.setExperienceLevel(updatedJobPosting.getExperienceLevel());
                    jobPosting.setLocation(updatedJobPosting.getLocation());
                    jobPosting.setSalaryRange(updatedJobPosting.getSalaryRange());
                    jobPosting.setApplicationDeadline(updatedJobPosting.getApplicationDeadline());
                    jobPosting.setResponsibilities(updatedJobPosting.getResponsibilities());
                    jobPosting.setRequirements(updatedJobPosting.getRequirements());
                    jobPosting.setPublishedDate(updatedJobPosting.getPublishedDate());
                    jobPosting.setFilled(updatedJobPosting.isFilled());
                    return jobPostingRepository.save(jobPosting);
                })
                .orElse(null);
    }

    public void deleteJobPosting(Long jobId) {
        jobPostingRepository.deleteById(jobId);
    }
}
