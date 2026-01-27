package com.teamstep.stepbackend.domain.company.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
@Table(name = "companies")
public class Company {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String companyName;
    private String businesspersonCode;
    private String location;
    private String representativeName;
    private String foundationDate;
    private String websiteUrl;
    private String type;
    private String area;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String capital;
    private String annualSales;
    private Long totalEmployee;
    private Long maleEmployee;
    private Long femaleEmployee;
    private String managerDepartment;
    private String managerPosition;
    private String managerName;
    private String managerFax;
    private String managerPhoneNumber;
    private String managerCellPhoneNumber;
    private String managerEmail;
}
