package com.teamstep.stepbackend.domain.recruitment.application.dto.response;

import com.teamstep.stepbackend.domain.recruitment.entity.Recruitment;

public record RecruitmentSummaryDto(
        String recruitmentId,
        String startDate,
        String endDate
) {
    public static RecruitmentSummaryDto from(Recruitment recruitment) {
        return new RecruitmentSummaryDto(
                recruitment.getRecruitmentId(),
                recruitment.getStartDate(),
                recruitment.getEndDate()
        );
    }
}
