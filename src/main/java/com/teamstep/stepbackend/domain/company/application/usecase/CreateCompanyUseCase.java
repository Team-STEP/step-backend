package com.teamstep.stepbackend.domain.company.application.usecase;

import com.teamstep.stepbackend.domain.company.application.dto.request.CompanyCreateRequestDto;
import com.teamstep.stepbackend.domain.company.application.dto.response.CompanyCreateResponseDto;
import com.teamstep.stepbackend.domain.company.application.repository.CompanyRepository;
import com.teamstep.stepbackend.domain.company.entity.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateCompanyUseCase {

    private final CompanyRepository companyRepository;

    @Transactional
    public CompanyCreateResponseDto createCompany(CompanyCreateRequestDto requestDto) {
        Company company = requestDto.toEntity();
        Company savedCompany = companyRepository.save(company);
        return CompanyCreateResponseDto.from(savedCompany);
    }
}
