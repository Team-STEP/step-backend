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
    private String id; // 회사 아이디
    private String companyName; // 회사명
    private String businesspersonCode; //사업자 번호
    private String location; // 회사 위치
    private String representativeName; //대표자명
    private String foundationDate; //설립 일자
    private String websiteUrl; //웹사이트 url
    private String type; //업태
    private String area; //종목
    @Column(columnDefinition = "TEXT")
    private String description; //주요 사업 내용
    private String capital; //자본금
    private String annualSales; //연매출액
    private Long maleEmployee; //남성 직원수
    private Long femaleEmployee; //여성 직원수
    private String managerDepartment; //채용담당자 부서
    private String managerPosition; //채용담당자 직책
    private String managerName; //채용담당자 성명
    private String managerFax; //채용담당자 팩스
    private String managerPhoneNumber; //채용담당자 전화기 번호
    private String managerCellPhoneNumber; //채용담당자 휴대폰 번호
    private String managerEmail; //채용담당자 이메일
}
