package com.ims.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ims.api.dao.CandidateRepository;
import com.ims.api.entities.Candidate;

@Service
public class CandidateService {

    @Autowired
    private  CandidateRepository candidateRepository;

    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    public Optional<Candidate> getCandidateById(Long candidateId) {
        return candidateRepository.findById(candidateId);
    }

    public Candidate createCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    public Candidate updateCandidate(Long candidateId, Candidate updatedCandidate) {
        return candidateRepository.findById(candidateId).map(candidate -> {
                    candidate.setName(updatedCandidate.getName());
                    candidate.setEmail(updatedCandidate.getEmail());
                    candidate.setPhone(updatedCandidate.getPhone());
                    candidate.setResume(updatedCandidate.getResume());
                    candidate.setCoverLetter(updatedCandidate.getCoverLetter());
                    candidate.setDateOfBirth(updatedCandidate.getDateOfBirth());
                    candidate.setGender(updatedCandidate.getGender());
                    candidate.setEducation(updatedCandidate.getEducation());
                    candidate.setExperience(updatedCandidate.getExperience());
                    return candidateRepository.save(candidate);
                }).orElse(null);
    }

    public void deleteCandidate(Long candidateId) {
        candidateRepository.deleteById(candidateId);
    }
}
