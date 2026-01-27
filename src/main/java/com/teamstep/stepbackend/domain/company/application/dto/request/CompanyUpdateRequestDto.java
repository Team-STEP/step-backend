package com.teamstep.stepbackend.domain.company.application.dto.request;

import com.teamstep.stepbackend.domain.company.application.dto.response.CompanySearchReponseDto;

import java.util.List;

public record CompanyUpdateRequestDto(
        List<CompanySearchReponseDto> companies
) {}
