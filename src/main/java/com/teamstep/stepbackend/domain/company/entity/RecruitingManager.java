package com.teamstep.stepbackend.domain.company.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class RecruitingManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String department;
    private String position;
    private String name;
    private String fax;
    private String phoneNumber;
    private String cellPhoneNumber;
    private String email;
}
