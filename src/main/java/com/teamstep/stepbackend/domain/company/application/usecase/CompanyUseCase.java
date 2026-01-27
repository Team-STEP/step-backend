package com.teamstep.stepbackend.domain.company.application.usecase;

import com.teamstep.stepbackend.domain.company.application.repository.CompanyRepository;
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
    // UpdateCompany
    // CreateCompany
}
