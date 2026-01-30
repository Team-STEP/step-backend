package com.teamstep.stepbackend.domain.company.application.dto.request;

public record CompanyDetailSearchRequestDto(
        String id
) {
    public static CompanyDetailSearchRequestDto toDto(String companyId) {
        return new CompanyDetailSearchRequestDto(companyId);
    }
}
