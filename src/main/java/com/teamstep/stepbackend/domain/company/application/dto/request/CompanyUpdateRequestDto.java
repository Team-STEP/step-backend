package com.teamstep.stepbackend.domain.company.application.dto.request;

import com.teamstep.stepbackend.domain.company.application.dto.response.CompanySearchResponseDto;

import java.util.List;

public record CompanyUpdateRequestDto(
        List<CompanySearchResponseDto> companies
) {}
