package com.teamstep.stepbackend.domain.company.application.usecase;

import com.teamstep.stepbackend.domain.company.application.dto.request.CompanyCreateRequestDto;
import com.teamstep.stepbackend.domain.company.application.dto.request.CompanyUpdateRequestDto;
import com.teamstep.stepbackend.domain.company.application.dto.response.CompanyCreateResponseDto;
import com.teamstep.stepbackend.domain.company.application.dto.response.CompanyDetailSearchResponseDto;
import com.teamstep.stepbackend.domain.company.application.dto.response.CompanyListSearchResposneDto;
import com.teamstep.stepbackend.domain.company.application.dto.response.CompanySearchResponseDto;
import com.teamstep.stepbackend.domain.company.application.exception.CompanyNotFoundException;
import com.teamstep.stepbackend.domain.company.application.repository.CompanyRepository;
import com.teamstep.stepbackend.domain.company.entity.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CompanyUseCase {

    private final CompanyRepository companyRepository;

    // Read
    // GetCompany
    @Transactional(readOnly = true)
    public CompanyDetailSearchResponseDto getCompanyById(String companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new CompanyNotFoundException("해당 회사가 존재하지 않습니다."));

        return CompanyDetailSearchResponseDto.from(company);
    }
    // GetCompanyList
    @Transactional(readOnly = true)
    public CompanyListSearchResposneDto getCompanyList(CompanySearchResponseDto) {

    }

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
