package com.teamstep.stepbackend.domain.company.application.dto.response;

import com.teamstep.stepbackend.domain.company.entity.Company;

public record CompanySearchResponseDto(
    String companyName,
    String area,
    String location,
    String managerDepartment,
    String managerPosition,
    String managerName,
    String id
) {
    public static CompanySearchResponseDto from(Company company) {
        return new CompanySearchResponseDto(
                company.getCompanyName(),
                company.getArea(),
                company.getLocation(),
                company.getManagerDepartment(),
                company.getManagerPosition(),
                company.getManagerName(),
                company.getId()
        );
    }
}
