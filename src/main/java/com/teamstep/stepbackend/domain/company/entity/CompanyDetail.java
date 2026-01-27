package com.teamstep.stepbackend.domain.company.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class CompanyDetail {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String type;
    private String area;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String capital;
    private String annualSales;
    private Long totalEmployee;
    private Long maleEmployee;
    private Long femaleEmployee;
}
