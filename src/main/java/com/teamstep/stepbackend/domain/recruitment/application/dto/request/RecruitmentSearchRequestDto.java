package com.teamstep.stepbackend.domain.recruitment.application.dto.request;

public record RecruitmentSearchRequestDto(
        String companyName,
        String location,
        String area
) {
}
