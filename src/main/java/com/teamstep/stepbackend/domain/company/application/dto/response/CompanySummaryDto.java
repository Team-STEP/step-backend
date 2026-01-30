package com.teamstep.stepbackend.domain.company.application.dto.response;

import com.teamstep.stepbackend.domain.company.entity.Company;

public record CompanySummaryDto(
        String companyName,
        String area,
        String location
) {
    public static CompanySummaryDto from(Company company) {
        return new CompanySummaryDto(
                company.getCompanyName(),
                company.getArea(),
                company.getLocation()
        );
    }
}
