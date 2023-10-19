package com.ims.api.entities;

import java.time.LocalDateTime;

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
public class Application{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long applicationID;

    @ManyToOne
    private JobPosting jobPosting;

    @OneToOne
    private Candidate candidate;

    private String status;
    private LocalDateTime submissionDate;
    private String coverLetterText;
    private LocalDateTime statusDate;

}