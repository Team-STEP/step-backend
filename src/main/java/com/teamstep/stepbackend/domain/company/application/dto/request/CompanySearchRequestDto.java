package com.teamstep.stepbackend.domain.company.application.dto.request;

public record CompanySearchRequestDto(
        String companyName,
        String location,
        String area
) {}
