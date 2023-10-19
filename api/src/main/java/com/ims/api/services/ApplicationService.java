package com.ims.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ims.api.dao.ApplicationRepository;
import com.ims.api.entities.Application;

@Service
public class ApplicationService {
    @Autowired
    private final ApplicationRepository applicationRepository;
    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    public Optional<Application> getApplicationById(Long applicationID) {
        return applicationRepository.findById(applicationID);
    }

    public Application createApplication(Application application) {
        // Additional validation or business logic can be added here
        return applicationRepository.save(application);
    }

    public Application updateApplication(Long applicationID, Application updatedApplication) {
        // Additional validation or business logic can be added here
        return applicationRepository.findById(applicationID)
                .map(application -> {
                    application.setJobPosting(updatedApplication.getJobPosting());
                    application.setCandidate(updatedApplication.getCandidate());
                    application.setStatus(updatedApplication.getStatus());
                    application.setSubmissionDate(updatedApplication.getSubmissionDate());
                    application.setCoverLetterText(updatedApplication.getCoverLetterText());
                    application.setStatusDate(updatedApplication.getStatusDate());
                    return applicationRepository.save(application);
                })
                .orElse(null);
    }

    public void deleteApplication(Long applicationID) {
        applicationRepository.deleteById(applicationID);
    }
}
