package com.teamstep.stepbackend.domain.company.application.usecase;

import com.teamstep.stepbackend.domain.company.application.dto.request.CompanyUpdateRequestDto;
import com.teamstep.stepbackend.domain.company.application.exception.CompanyNotFoundException;
import com.teamstep.stepbackend.domain.company.application.repository.CompanyRepository;
import com.teamstep.stepbackend.domain.company.entity.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateCompanyUseCase {

    private final CompanyRepository companyRepository;

    @Transactional
    public void updateCompany(String id, CompanyUpdateRequestDto requestDto){
        companyRepository.findById(id)
                .orElseThrow(() -> new CompanyNotFoundException("해당 회사가 존재하지 않습니다."));
        Company company = requestDto.toEntity(id);
        companyRepository.save(company);
    }
}
