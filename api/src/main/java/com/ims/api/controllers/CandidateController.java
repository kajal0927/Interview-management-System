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

import com.ims.api.entities.Candidate;
import com.ims.api.services.CandidateService;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {


    @Autowired
    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping
    public List<Candidate> getAllCandidates() {
        return candidateService.getAllCandidates();
    }

    @GetMapping("/{candidateId}")
    public ResponseEntity<Candidate> getCandidateById(@PathVariable Long candidateId) {
        Optional<Candidate> candidate = candidateService.getCandidateById(candidateId);
        return candidate.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Candidate> createCandidate(@RequestBody Candidate candidate) {
        Candidate createdCandidate = candidateService.createCandidate(candidate);
        return ResponseEntity.ok(createdCandidate);
    }

    @PutMapping("/{candidateId}")
    public ResponseEntity<Candidate> updateCandidate(@PathVariable Long candidateId,@RequestBody Candidate updatedCandidate) {
        Candidate candidate = candidateService.updateCandidate(candidateId, updatedCandidate);
        return candidate != null ? ResponseEntity.ok(candidate) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{candidateId}")
    public ResponseEntity<Void> deleteCandidate(@PathVariable Long candidateId) {
        candidateService.deleteCandidate(candidateId);
        return ResponseEntity.noContent().build();
    }
}
