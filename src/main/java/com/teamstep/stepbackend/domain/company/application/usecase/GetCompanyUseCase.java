package com.teamstep.stepbackend.domain.company.application.usecase;

import com.teamstep.stepbackend.domain.company.application.dto.response.CompanyDetailSearchResponseDto;
import com.teamstep.stepbackend.domain.company.application.exception.CompanyNotFoundException;
import com.teamstep.stepbackend.domain.company.application.repository.CompanyRepository;
import com.teamstep.stepbackend.domain.company.entity.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class GetCompanyUseCase {

    private final CompanyRepository companyRepository;

    // Read
    // GetCompany
    @Transactional(readOnly = true)
    public CompanyDetailSearchResponseDto getCompanyById(String companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new CompanyNotFoundException("해당 회사가 존재하지 않습니다."));

        return CompanyDetailSearchResponseDto.from(company);
    }
}
