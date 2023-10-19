package com.ims.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ims.api.dao.InterviewRepository;
import com.ims.api.entities.Interview;

@Service
public class InterviewService {
    @Autowired
    private final InterviewRepository interviewRepository;

    public InterviewService(InterviewRepository interviewRepository) {
        this.interviewRepository = interviewRepository;
    }

    public List<Interview> getAllInterviews() {
        return interviewRepository.findAll();
    }

    public Optional<Interview> getInterviewById(Long interviewID) {
        return interviewRepository.findById(interviewID);
    }

    public Interview createInterview(Interview interview) {
        // Additional validation or business logic can be added here
        return interviewRepository.save(interview);
    }

    public Interview updateInterview(Long interviewID, Interview updatedInterview) {
        // Additional validation or business logic can be added here
        return interviewRepository.findById(interviewID)
                .map(interview -> {
                    interview.setJobPosting(updatedInterview.getJobPosting());
                    interview.setCandidate(updatedInterview.getCandidate());
                    interview.setRoundNumber(updatedInterview.getRoundNumber());
                    interview.setInterviewers(updatedInterview.getInterviewers());
                    interview.setScheduledDate(updatedInterview.getScheduledDate());
                    interview.setScheduledTime(updatedInterview.getScheduledTime());
                    interview.setLocation(updatedInterview.getLocation());
                    interview.setStatus(updatedInterview.getStatus());
                    interview.setRound1Feedback(updatedInterview.getRound1Feedback());
                    interview.setRound1Rating(updatedInterview.getRound1Rating());
                    interview.setRound2Feedback(updatedInterview.getRound2Feedback());
                    interview.setRound2Rating(updatedInterview.getRound2Rating());
                    interview.setRound3Feedback(updatedInterview.getRound3Feedback());
                    interview.setRound3Rating(updatedInterview.getRound3Rating());
                    interview.setInterviewType(updatedInterview.getInterviewType());
                    interview.setInterviewDuration(updatedInterview.getInterviewDuration());
                    interview.setInterviewResult(updatedInterview.getInterviewResult());
                    interview.setNotes(updatedInterview.getNotes());
                    return interviewRepository.save(interview);
                })
                .orElse(null);
    }

    public void deleteInterview(Long interviewID) {
        interviewRepository.deleteById(interviewID);
    }
}
