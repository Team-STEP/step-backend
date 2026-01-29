package com.teamstep.stepbackend.domain.company.application.dto.response;

import com.teamstep.stepbackend.domain.company.entity.Company;
import com.teamstep.stepbackend.domain.recruitment.application.dto.response.RecruitmentSummaryDto;

import java.util.List;

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
        List<RecruitmentSummaryDto> recruitments
) {
    public static CompanyDetailSearchResponseDto of(Company company, List<RecruitmentSummaryDto> recruitments) {
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
                recruitments
        );
    }
}