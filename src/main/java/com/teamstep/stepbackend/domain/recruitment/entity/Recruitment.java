package com.teamstep.stepbackend.domain.recruitment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
@Table(name = "recruitments")
public class Recruitment {
    @Id
    private String id; //회사 Id

    @Column(name = "preferred_qualifications")
    private String preferredQualifications; //우대자격

    @Column(name = "other_requirement")
    private String otherRequirement; //기타 요구사항

    //필요 서류 관련
    @Column(name = "document_resume")
    private boolean documentResume; //이력서

    @Column(name = "document_introduction")
    private boolean documentIntroduction; //자소서

    @Column(name = "document_student_record")
    private boolean documentStudentRecord; //생기부

    @Column(name = "document_other")
    private String documentOther; //기타

    //모집 인원 관련
    @Column(name = "target_male")
    private int targetMale; //남성 모집인원

    @Column(name = "target_female")
    private int targetFemale; //여성 모집인원

    //모집 희망 학과 관련
    private String major; //학과
    // 인원수는 위와 겹쳐서 작성안함 :)

    //근무 관련
    @Column(name = "job_type")
    private String jobType; //모집 직종

    @Column(name = "job_department")
    private String jobDepartment; //근무부서

    @Column(name = "job_description")
    private String jobDescription; //직무내용


    @Column(name = "work_days")
    private String workDays; //주 5일 or 주 6일 or 격주 토요일 이런거 들어오는곳

    @Column(name = "work_time")
    private String workTime; //근무시간

    //4대 보험관련
    @Column(name = "national_pension")
    private String nationalPension;

    @Column(name = "health_insurance")
    private String healthInsurance;

    @Column(name = "employment_insurance")
    private String employmentInsurance;

    @Column(name = "workers_compensation")
    private String workersCompensation;

    //실습 수당 및 급여 관련
    @Column(name = "internship_allowance_type")
    private String internshipAllowanceType; //실습수당이 시급인지 월급인지

    @Column(name = "internship_allowance_amount")
    private String internshipAllowanceAmount; //실습 수당이 얼마인지

    @Column(name = "salary_type")
    private String salaryType; //급여가 시급인지 월급인지 연봉인지

    @Column(name = "salary_amount")
    private String salaryAmount; //급여가 얼마인지

    private String bonus; //상여

    //근로조건
    @Column(name = "condition_internship")
    private String conditionInternship; //인턴 여부

    @Column(name = "condition_convertible")
    private String conditionConvertible; //실습 종료 취업 전환 여부

    @Column(name = "condition_military_exception")
    private String conditionMilitaryException; //병역 특례

    @Column(name = "condition_welfare")
    private String conditionWelfare; //복리후생

    @Column(name = "condition_transportation")
    private String conditionTransportation; //회사교통편


    @Column(name = "start_date")
    private String startDate; //공고 시작일

    @Column(name = "end_date")
    private String endDate; //공고 마감일
}
