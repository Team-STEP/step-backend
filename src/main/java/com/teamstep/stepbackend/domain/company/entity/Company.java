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
    @Id
    @Column(name = "company_id")
    private String companyId; // 회사 아이디

    @Column(name = "company_name")
    private String companyName; // 회사명

    @Column(name = "businessperson_code")
    private String businesspersonCode; // 사업자 번호

    private String location; // 회사 위치

    @Column(name = "representative_name")
    private String representativeName; // 대표자명

    @Column(name = "foundation_date")
    private String foundationDate; // 설립 일자

    @Column(name = "website_url")
    private String websiteUrl; // 웹사이트 url

    private String type; // 업태
    private String area; // 종목

    @Column(columnDefinition = "TEXT")
    private String description; // 주요 사업 내용

    private String capital; // 자본금

    @Column(name = "annual_sales")
    private String annualSales; // 연매출액

    @Column(name = "male_employee")
    private Long maleEmployee; // 남성 직원수

    @Column(name = "female_employee")
    private Long femaleEmployee; // 여성 직원수

    @Column(name = "manager_department")
    private String managerDepartment; // 채용담당자 부서

    @Column(name = "manager_position")
    private String managerPosition; // 채용담당자 직책

    @Column(name = "manager_name")
    private String managerName; // 채용담당자 성명

    @Column(name = "manager_fax")
    private String managerFax; // 채용담당자 팩스

    @Column(name = "manager_phone_number")
    private String managerPhoneNumber; // 채용담당자 전화기 번호

    @Column(name = "manager_cell_phone_number")
    private String managerCellPhoneNumber; // 채용담당자 휴대폰 번호

    @Column(name = "manager_email")
    private String managerEmail; // 채용담당자 이메일
}
