package com.teamstep.stepbackend.domain.company.application.dto.response;

import java.util.List;

public record CompanyListSearchResponseDto(
        Long companyCount,
        List<CompanySearchResponseDto> companies
) {
    public static CompanyListSearchResponseDto of(Long companyCount, List<CompanySearchResponseDto> companies) {
        return new CompanyListSearchResponseDto(companyCount, companies);
    }
}
