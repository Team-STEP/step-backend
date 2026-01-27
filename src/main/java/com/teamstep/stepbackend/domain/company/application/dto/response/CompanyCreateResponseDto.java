package com.teamstep.stepbackend.domain.company.application.dto.response;

import com.teamstep.stepbackend.domain.company.entity.Company;

public record CompanyCreateResponseDto(
        String id
) {
    public static CompanyCreateResponseDto from(Company company) {
        return new CompanyCreateResponseDto(
                company.getId()
        );
    }
}
