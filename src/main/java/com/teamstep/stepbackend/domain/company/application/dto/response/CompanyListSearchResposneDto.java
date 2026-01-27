package com.teamstep.stepbackend.domain.company.application.dto.response;

import java.util.List;

public record CompanyListSearchResposneDto(
        Long companyCount,
        List<CompanySearchResponseDto> companies
) {
    public static CompanyListSearchResposneDto of(Long companyCount, List<CompanySearchResponseDto> companies) {
        return new CompanyListSearchResposneDto(companyCount, companies);
    }
}
