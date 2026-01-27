package com.teamstep.stepbackend.domain.company.application.usecase;

import com.teamstep.stepbackend.domain.company.application.dto.request.CompanyCreateRequestDto;
import com.teamstep.stepbackend.domain.company.application.dto.request.CompanyUpdateRequestDto;
import com.teamstep.stepbackend.domain.company.application.dto.response.CompanyCreateResponseDto;
import com.teamstep.stepbackend.domain.company.application.repository.CompanyRepository;
import com.teamstep.stepbackend.domain.company.entity.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyUseCase {

    private final CompanyRepository companyRepository;

    // Read
    // GetCompany
    // GetCompanyList

    // Write
    public void updateCompany(CompanyUpdateRequestDto requestDto){
        Company company = requestDto.toEntity();
        companyRepository.save(company);
        return;
    }

    public CompanyCreateResponseDto createCompany(CompanyCreateRequestDto requestDto) {
        Company company = requestDto.toEntity();
        Company savedCompany = companyRepository.save(company);
        return CompanyCreateResponseDto.from(savedCompany);
    }
}
