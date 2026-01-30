package com.teamstep.stepbackend.domain.recruitment.application.dto.request;

public record RecruitmentListSearchRequestDto(
        String companyName,
        String location,
        String area
) {
}
