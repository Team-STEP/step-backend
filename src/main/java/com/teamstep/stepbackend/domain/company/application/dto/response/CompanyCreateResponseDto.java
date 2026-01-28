package com.teamstep.stepbackend.domain.company.application.dto.response;

import com.teamstep.stepbackend.domain.company.entity.Company;

public record CompanyCreateResponseDto(
        String companyId
) {
    public static CompanyCreateResponseDto from(Company company) {
        return new CompanyCreateResponseDto(
                company.getCompanyId()
        );
    }
}
