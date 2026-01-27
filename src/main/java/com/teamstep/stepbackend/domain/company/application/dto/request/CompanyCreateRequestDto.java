package com.teamstep.stepbackend.domain.company.application.dto.request;

import com.teamstep.stepbackend.domain.company.entity.Company;

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
    public Company toEntity(){
        return Company.builder()
                .companyName(this.companyName)
                .businesspersonCode(this.businesspersonCode)
                .location(this.location)
                .representativeName(this.representativeName)
                .foundationDate(this.foundationDate)
                .websiteUrl(this.websiteUrl)
                .type(this.type)
                .area(this.area)
                .description(this.description)
                .capital(this.capital)
                .annualSales(this.annualSales)
                .maleEmployee(this.maleEmployee)
                .femaleEmployee(this.femaleEmployee)
                .managerDepartment(this.managerDepartment)
                .managerPosition(this.managerPosition)
                .managerName(this.managerName)
                .managerFax(this.managerFax)
                .managerPhoneNumber(this.managerPhoneNumber)
                .managerCellPhoneNumber(this.managerCellPhoneNumber)
                .managerEmail(this.managerEmail)
                .build();
    }
}
