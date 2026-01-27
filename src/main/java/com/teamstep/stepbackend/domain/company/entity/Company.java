package com.teamstep.stepbackend.domain.company.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Company {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String companyName;
    private String businesspersonCode;
    private String location;
    private String representativeName;
    private String foundationDate;
    private String websiteUrl;
}
