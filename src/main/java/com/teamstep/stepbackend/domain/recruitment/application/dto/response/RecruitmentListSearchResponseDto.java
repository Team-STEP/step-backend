package com.teamstep.stepbackend.domain.recruitment.application.dto.response;

import java.util.List;

public record RecruitmentListSearchResponseDto(
        Long recruitmentCount,
        List<RecruitmentSearchResponseDto> recruitments
) {
    public static RecruitmentListSearchResponseDto of(Long recruitmentCount, List<RecruitmentSearchResponseDto> recruitments) {
        return new RecruitmentListSearchResponseDto(recruitmentCount, recruitments);
    }
}
