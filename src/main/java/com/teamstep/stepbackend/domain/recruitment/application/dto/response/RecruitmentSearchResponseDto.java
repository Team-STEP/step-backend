package com.teamstep.stepbackend.domain.recruitment.application.dto.response;

import com.teamstep.stepbackend.domain.company.application.dto.response.CompanySummaryDto;
import com.teamstep.stepbackend.domain.recruitment.entity.Recruitment;

import java.util.List;

public record RecruitmentSearchResponseDto(
        String recruitmentId,
        String jobDescription,
        String major,
        String jobType,
        CompanySummaryDto company
) {
    public static RecruitmentSearchResponseDto from(Recruitment recruitment){
        return new RecruitmentSearchResponseDto(
                recruitment.getRecruitmentId(),
                recruitment.getJobDescription(),
                recruitment.getMajor(),
                recruitment.getJobType(),
                CompanySummaryDto.from(recruitment.getCompany())
        );
    }
}
