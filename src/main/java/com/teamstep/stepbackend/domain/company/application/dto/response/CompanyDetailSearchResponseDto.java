package com.teamstep.stepbackend.domain.company.application.dto.response;

import com.teamstep.stepbackend.domain.company.entity.Company;

public record CompanyDetailSearchResponseDto(
        String id,
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
        String managerEmail
        //공고 들어갈자리
) {
    public static CompanyDetailSearchResponseDto from(Company company) {
        return new CompanyDetailSearchResponseDto(
                company.getId(),
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
                company.getManagerEmail()
                //공고 들어갈자리
                );
    }
}