package com.teamstep.stepbackend.domain.recruitment.application.dto.response;

import com.teamstep.stepbackend.domain.company.entity.Company;
import com.teamstep.stepbackend.domain.recruitment.entity.Recruitment;

public record RecruitmentCreateResponseDto(
        String recruitmentId
) {
    public static RecruitmentCreateResponseDto from(Recruitment recruitment) {
        return new RecruitmentCreateResponseDto(
                recruitment.getRecruitmentId()
        );
    }
}
