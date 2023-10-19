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

import com.ims.api.entities.Application;
import com.ims.api.services.ApplicationService;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {
    @Autowired
    private final ApplicationService applicationService;
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping
    public List<Application> getAllApplications() {
        return applicationService.getAllApplications();
    }

    @GetMapping("/{applicationID}")
    public ResponseEntity<Application> getApplicationById(@PathVariable Long applicationID) {
        Optional<Application> application = applicationService.getApplicationById(applicationID);
        return application.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Application> createApplication(@RequestBody Application application) {
        Application createdApplication = applicationService.createApplication(application);
        return ResponseEntity.ok(createdApplication);
    }

    @PutMapping("/{applicationID}")
    public ResponseEntity<Application> updateApplication(@PathVariable Long applicationID,@RequestBody Application updatedApplication) {
        Application application = applicationService.updateApplication(applicationID, updatedApplication);
        return application != null ? ResponseEntity.ok(application) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{applicationID}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long applicationID) {
        applicationService.deleteApplication(applicationID);
        return ResponseEntity.noContent().build();
    }
}
