package com.teamstep.stepbackend.domain.company.application.dto.response;

import com.teamstep.stepbackend.domain.company.entity.Company;

public record CompanySearchReponseDto(
    String companyName,
    String area,
    String location,
    String managerDepartment,
    String managerPosition,
    String managerName,
    String id
) {
    public static CompanySearchReponseDto from(Company company) {
        return new CompanySearchReponseDto(
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
