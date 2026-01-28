package com.teamstep.stepbackend.domain.recruitment.application.dto.request;

import com.teamstep.stepbackend.domain.recruitment.entity.Recruitment;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RecruitmentCreateRequestDto(
        @NotBlank(message = "우대자격은 공백이 안됨")
        String preferredQualifications,
        @NotBlank(message = "기타 요구사항은 공백이 안됨")
        String otherRequirement,
        @NotNull(message = "이력서는 공백이 안됨")
        boolean documentResume,
        @NotNull(message = "자소서는 공백이 안됨")
        boolean documentIntroduction,
        @NotNull(message = "생기부는 공백이 안됨")
        boolean documentStudentRecord,
        @NotBlank(message = "기타는 공백이 안됨")
        String documentOther,
        @NotNull(message = "남성 모집인원은 공백이 안됨")
        int targetMale,
        @NotNull(message = "여성 모집인원은 공백이 안됨")
        int targetFemale,
        @NotBlank(message = "학과는 공백이 안됨")
        String major,
        @NotBlank(message = "모집 직종은 공백이 안됨")
        String jobType,
        @NotBlank(message = "근무부서는 공백이 안됨")
        String jobDepartment,
        @NotBlank(message = "직무내용은 공백이 안됨")
        String jobDescription,
        @NotBlank(message = "근무일은 공백이 안됨")
        String workDays,
        @NotBlank(message = "근무시간은 공백이 안됨")
        String workTime,
        @NotBlank(message = "4대보험은 공백이 안됨")
        String nationalPension,
        @NotBlank(message = "4대보험은 공백이 안됨")
        String healthInsurance,
        @NotBlank(message = "4대보험은 공백이 안됨")
        String employmentInsurance,
        @NotBlank(message = "4대보험은 공백이 안됨")
        String workersCompensation,
        @NotBlank(message = "실습수당(방법)은 공백이 안됨")
        String internshipAllowanceType,
        @NotBlank(message = "실습수당은 공백이 안됨")
        String internshipAllowanceAmount,
        @NotBlank(message = "급여(방법)는 공백이 안됨")
        String salaryType,
        @NotBlank(message = "급여는 공백이 안됨")
        String salaryAmount,
        @NotBlank(message = "상여는 공백이 안됨")
        String bonus,
        @NotBlank(message = "인턴 여부는 공백이 안됨")
        String conditionInternship,
        @NotBlank(message = "실습 종료 취업 전환 여부는 공백이 안됨")
        String conditionConvertible,
        @NotBlank(message = "병역 특례 여부는 공백이 안됨")
        String conditionMilitaryException,
        @NotBlank(message = "복리후생은 공백이 안됨")
        String conditionWelfare,
        @NotBlank(message = "회사교통편은 공백이 안됨")
        String conditionTransportation,
        @NotBlank(message = "공고 시작일은 공백이 안됨")
        String startDate,
        @NotBlank(message = "공고 마감일은 공백이 안됨")
        String endDate
) {
    public Recruitment toEntity() {
        return Recruitment.builder()
                .preferredQualifications(this.preferredQualifications)
                .otherRequirement(this.otherRequirement)
                .documentResume(this.documentResume)
                .documentIntroduction(this.documentIntroduction)
                .documentStudentRecord(this.documentStudentRecord)
                .documentOther(this.documentOther)
                .targetMale(this.targetMale)
                .targetFemale(this.targetFemale)
                .major(this.major)
                .jobType(this.jobType)
                .jobDepartment(this.jobDepartment)
                .jobDescription(this.jobDescription)
                .workDays(this.workDays)
                .workTime(this.workTime)
                .nationalPension(this.nationalPension)
                .healthInsurance(this.healthInsurance)
                .employmentInsurance(this.employmentInsurance)
                .workersCompensation(this.workersCompensation)
                .internshipAllowanceType(this.internshipAllowanceType)
                .internshipAllowanceAmount(this.internshipAllowanceAmount)
                .salaryType(this.salaryType)
                .salaryAmount(this.salaryAmount)
                .bonus(this.bonus)
                .conditionInternship(this.conditionInternship)
                .conditionConvertible(this.conditionConvertible)
                .conditionMilitaryException(this.conditionMilitaryException)
                .conditionWelfare(this.conditionWelfare)
                .conditionTransportation(this.conditionTransportation)
                .startDate(this.startDate)
                .endDate(this.endDate)
                .build();
    }
}
