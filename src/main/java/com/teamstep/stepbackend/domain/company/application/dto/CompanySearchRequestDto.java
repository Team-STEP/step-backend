package com.teamstep.stepbackend.domain.company.application.dto;

public record CompanySearchRequestDto(
        String companyName,
        String location,
        String area
) {}
