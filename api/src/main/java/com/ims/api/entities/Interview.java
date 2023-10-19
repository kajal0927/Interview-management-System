package com.ims.api.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Interview {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long interviewID;

    //@OneToMany
    @ManyToOne
    private JobPosting jobPosting;

    @OneToOne
    private Candidate candidate;

    private int roundNumber;

    @OneToMany
    private List<Interviewer> interviewers;

    private LocalDate scheduledDate;
    private LocalTime scheduledTime;
    private String location;
    private String status;
    private String round1Feedback;
    private int round1Rating;
    private String round2Feedback;
    private int round2Rating;
    private String round3Feedback;
    private int round3Rating;
    private String interviewType;
    private int interviewDuration;
    private String interviewResult;
    private String notes;
}