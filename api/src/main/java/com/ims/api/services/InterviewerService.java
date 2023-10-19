package com.ims.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ims.api.dao.InterviewerRepository;
import com.ims.api.entities.Interviewer;

@Service
public class InterviewerService {

    @Autowired
    private  InterviewerRepository interviewerRepository;

    public InterviewerService(InterviewerRepository interviewerRepository) {
        this.interviewerRepository = interviewerRepository;
    }

    public List<Interviewer> getAllInterviewers() {
        return interviewerRepository.findAll();
    }

    public Optional<Interviewer> getInterviewerById(Long interviewerId) {
        return interviewerRepository.findById(interviewerId);
    }

    public Interviewer createInterviewer(Interviewer interviewer){
        return interviewerRepository.save(interviewer);
    }

    public Interviewer updateInterviewer(Long interviewerId, Interviewer updatedInterviewer) {
        return interviewerRepository.findById(interviewerId).map(interviewer -> {
                    interviewer.setName(updatedInterviewer.getName());
                    interviewer.setEmail(updatedInterviewer.getEmail());
                    interviewer.setPhone(updatedInterviewer.getPhone());
                    return interviewerRepository.save(interviewer);
                }).orElse(null);
    }

    public void deleteInterviewer(Long interviewerId) {
        interviewerRepository.deleteById(interviewerId);
    }
}
