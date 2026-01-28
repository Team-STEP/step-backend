package com.teamstep.stepbackend.domain.recruitment.application.dto.response;

import com.teamstep.stepbackend.domain.company.entity.Company;
import com.teamstep.stepbackend.domain.recruitment.entity.Recruitment;

import java.util.List;

public record RecruitmentSearchResponseDto(
        String recruitmentId,
        Long recruitmentCount,
        String jobDescription,
        String major,
        String jobType,
        List<CompanySummaryDto> companies
) {
    public static RecruitmentSearchResponseDto of(Long recruitmentCount, Recruitment recruitment, List<CompanySummaryDto> companyList){
        return new RecruitmentSearchResponseDto(
                recruitment.getRecruitmentId(),
                recruitmentCount,
                recruitment.getJobDescription(),
                recruitment.getMajor(),
                recruitment.getJobType(),
                companyList
        );
    }
}
