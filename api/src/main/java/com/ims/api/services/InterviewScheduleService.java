package com.ims.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ims.api.dao.InterviewScheduleRepository;
import com.ims.api.entities.InterviewSchedule;

@Service
public class InterviewScheduleService {

    @Autowired
    private final InterviewScheduleRepository interviewScheduleRepository;

    public InterviewScheduleService(InterviewScheduleRepository interviewScheduleRepository) {
        this.interviewScheduleRepository = interviewScheduleRepository;
    }

    public List<InterviewSchedule> getAllInterviewSchedules() {
        return interviewScheduleRepository.findAll();
    }

    public Optional<InterviewSchedule> getInterviewScheduleById(Long scheduleID) {
        return interviewScheduleRepository.findById(scheduleID);
    }

    public InterviewSchedule createInterviewSchedule(InterviewSchedule interviewSchedule) {
        return interviewScheduleRepository.save(interviewSchedule);
    }

    public InterviewSchedule updateInterviewSchedule(Long scheduleID, InterviewSchedule updatedInterviewSchedule) {
    
        return interviewScheduleRepository.findById(scheduleID)
                .map(schedule -> {
                    schedule.setInterview(updatedInterviewSchedule.getInterview());
                    schedule.setRound(updatedInterviewSchedule.getRound());
                    schedule.setInterviewer(updatedInterviewSchedule.getInterviewer());
                    schedule.setScheduledDate(updatedInterviewSchedule.getScheduledDate());
                    schedule.setScheduledTime(updatedInterviewSchedule.getScheduledTime());
                    schedule.setLocation(updatedInterviewSchedule.getLocation());
                    schedule.setStatus(updatedInterviewSchedule.getStatus());
                    return interviewScheduleRepository.save(schedule);
                })
                .orElse(null);
    }

    public void deleteInterviewSchedule(Long scheduleID) {
        interviewScheduleRepository.deleteById(scheduleID);
    }
}
