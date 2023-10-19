package com.ims.api.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long candidateID;
    private String name;
    private String email;
    private String phone;
    private String resume;
    private String coverLetter;
    private LocalDate dateOfBirth;
    private String gender;
    private String education;
    private String experience;

    // getters and setters
    
}
