package com.teamstep.stepbackend.domain.company.application.dto.request;

public record CompanyCreateRequestDto(
        String companyName,
        String businesspersonCode,
        String location,
        String representativeName,
        String foundationDate,
        String websiteUrl,
        String type,
        String area,
        String description,
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
) {
}
