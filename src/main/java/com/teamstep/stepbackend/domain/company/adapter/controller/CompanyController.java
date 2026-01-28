package com.teamstep.stepbackend.domain.company.adapter.controller;

import com.teamstep.stepbackend.domain.company.application.dto.request.*;
import com.teamstep.stepbackend.domain.company.application.dto.response.*;
import com.teamstep.stepbackend.domain.company.application.usecase.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/companies")
public class CompanyController{

    private final CreateCompanyUseCase createCompanyUseCase;
    private final UpdateCompanyUseCase updateCompanyUseCase;
    private final GetCompanyListUseCase getCompanyListUseCase;
    private final GetCompanyUseCase getCompanyUseCase;

    // Write
    // Create
    @PostMapping
    public ResponseEntity<CompanyCreateResponseDto> createCompany(
            @Valid @RequestBody CompanyCreateRequestDto requestDto
    ) {
        CompanyCreateResponseDto response = createCompanyUseCase.createCompany(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Update
    @PostMapping("/{id}")
    public ResponseEntity<Void> updateCompany(
            @Valid @PathVariable("id") String id, @RequestBody CompanyUpdateRequestDto requestDto
    ) {
        updateCompanyUseCase.updateCompany(id, requestDto);
        return ResponseEntity.ok().build();
    }

    // Read
    // ListSearch
    @GetMapping
    public ResponseEntity<CompanyListSearchResposneDto> getCompanies(
            @ModelAttribute CompanySearchRequestDto filter,
            @PageableDefault(size = 20) Pageable pageable
    ) {
        return ResponseEntity.ok(getCompanyListUseCase.getCompanyList(filter, pageable));
    }

    // DetailSearch
    @GetMapping("/{companyId}")
    public ResponseEntity<CompanyDetailSearchResponseDto> getCompany(
            @PathVariable("companyId") String companyId
    ) {
        return ResponseEntity.ok(getCompanyUseCase.getCompanyById(companyId));
    }
}
