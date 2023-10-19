package com.ims.api.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class InterviewSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long scheduleID;

    @ManyToOne
    private Interview interview;

    @OneToOne
    private Round round;

    @OneToOne
    private Interviewer interviewer;

    private LocalDate scheduledDate;
    private LocalTime scheduledTime;
    private String location;
    private String status;

    // getters and setters


}