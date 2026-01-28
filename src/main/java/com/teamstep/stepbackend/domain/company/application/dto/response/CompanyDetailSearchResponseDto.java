package com.teamstep.stepbackend.domain.company.application.dto.response;

import com.teamstep.stepbackend.domain.company.entity.Company;
import com.teamstep.stepbackend.domain.recruitment.entity.Recruitment;

public record CompanyDetailSearchResponseDto(
        String companyId,
        String businesspersonCode,
        String location,
        String representativeName,
        String foundationDate,
        String type,
        String area,
        String description,
        String websiteUrl,
        String capital,
        String annualSales,
        Long maleEmployee,
        Long femaleEmployee,
        String managerDepartment,
        String managerPosition,
        String managerName,
        String managerFax,
        String managerPhoneNumber,
        String managerCellPhoneNumber,
        String managerEmail,
        String recruitmentId,
        String startDate,
        String endDate
) {
    public static CompanyDetailSearchResponseDto of(Company company, Recruitment recruitment) {
        return new CompanyDetailSearchResponseDto(
                company.getCompanyId(),
                company.getBusinesspersonCode(),
                company.getLocation(),
                company.getRepresentativeName(),
                company.getFoundationDate(),
                company.getType(),
                company.getArea(),
                company.getDescription(),
                company.getWebsiteUrl(),
                company.getCapital(),
                company.getAnnualSales(),
                company.getMaleEmployee(),
                company.getFemaleEmployee(),
                company.getManagerDepartment(),
                company.getManagerPosition(),
                company.getManagerName(),
                company.getManagerFax(),
                company.getManagerPhoneNumber(),
                company.getManagerCellPhoneNumber(),
                company.getManagerEmail(),
                recruitment.getRecruitmentId(),
                recruitment.getStartDate(),
                recruitment.getEndDate()
                );
    }
}