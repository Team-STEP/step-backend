package com.teamstep.stepbackend.domain.company.application.dto.request;

import com.teamstep.stepbackend.domain.company.application.dto.response.CompanySearchResponseDto;
import com.teamstep.stepbackend.domain.company.entity.Company;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CompanyUpdateRequestDto(
        @NotBlank(message = "회사명은 공백이 안됨")
        String companyName,
        @NotBlank(message = "사업자 번호는 공백이 안됨")
        String businesspersonCode,
        @NotBlank(message = "회사 위치는 공백이 안됨")
        String location,
        @NotBlank(message = "대표자명은 공백이 안됨")
        String representativeName,
        @NotBlank(message = "설립일자는 공백이 안됨")
        String foundationDate,
        @NotBlank(message = "웹사이트 url은 공백이 안됨")
        String websiteUrl,
        @NotBlank(message = "업태는 공백이 안됨")
        String type,
        @NotBlank(message = "종목은 공백이 안됨")
        String area,
        @NotBlank(message = "주요 사업 내용은 공백이 안됨")
        String description,
        @NotBlank(message = "자본금은 공백이 안됨")
        String capital,
        @NotBlank(message = "연매출액은 공백이 안됨")
        String annualSales,
        @NotNull(message = "남성 직원수는 공백이 안됨")
        Long maleEmployee,
        @NotNull(message = "여성 직원수는 공백이 안됨")
        Long femaleEmployee,
        @NotBlank(message = "채용담당자 부서는 공백이 안됨")
        String managerDepartment,
        @NotBlank(message = "채용담당자 직책은 공백이 안됨")
        String managerPosition,
        @NotBlank(message = "채용담당자 성명은 공백이 안됨")
        String managerName,
        @NotBlank(message = "채용담당자 팩스는 공백이 안됨")
        String managerFax,
        @NotBlank(message = "채용담당자 전화기 번호는 공백이 안됨")
        String managerPhoneNumber,
        @NotBlank(message = "채용담당자 휴대폰 번호는 공백이 안됨")
        String managerCellPhoneNumber,
        @NotBlank(message = "채용담당자 이메일은 공백이 안됨")
        String managerEmail
) {
    public Company toEntity(String id){
        return Company.builder()
                .id(id)
                .companyName(this.companyName)
                .businesspersonCode(this.businesspersonCode)
                .location(this.location)
                .representativeName(this.representativeName)
                .foundationDate(this.foundationDate)
                .websiteUrl(this.websiteUrl)
                .type(this.type)
                .area(this.area)
                .description(this.description)
                .capital(this.capital)
                .annualSales(this.annualSales)
                .maleEmployee(this.maleEmployee)
                .femaleEmployee(this.femaleEmployee)
                .managerDepartment(this.managerDepartment)
                .managerPosition(this.managerPosition)
                .managerName(this.managerName)
                .managerFax(this.managerFax)
                .managerPhoneNumber(this.managerPhoneNumber)
                .managerCellPhoneNumber(this.managerCellPhoneNumber)
                .managerEmail(this.managerEmail)
                .build();
    }
}
