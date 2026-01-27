package com.teamstep.stepbackend.domain.company.application.dto.response;

import java.util.List;

public record CompanyListSearchResposneDto(
        Long companyCount,
        List<CompanySearchReponseDto> companies
) {
    public static CompanyListSearchResposneDto of(Long companyCount, List<CompanySearchReponseDto> companies) {
        return new CompanyListSearchResposneDto(companyCount, companies);
    }
}
