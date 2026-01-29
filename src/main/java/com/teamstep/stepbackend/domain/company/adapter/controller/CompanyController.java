package com.teamstep.stepbackend.domain.company.adapter.controller;

import com.teamstep.stepbackend.domain.company.application.dto.request.CompanyCreateRequestDto;
import com.teamstep.stepbackend.domain.company.application.dto.request.CompanyDetailSearchRequestDto;
import com.teamstep.stepbackend.domain.company.application.dto.request.CompanySearchRequestDto;
import com.teamstep.stepbackend.domain.company.application.dto.request.CompanyUpdateRequestDto;
import com.teamstep.stepbackend.domain.company.application.dto.response.CompanyCreateResponseDto;
import com.teamstep.stepbackend.domain.company.application.dto.response.CompanyDetailSearchResponseDto;
import com.teamstep.stepbackend.domain.company.application.dto.response.CompanyListSearchResponseDto;
import com.teamstep.stepbackend.domain.company.application.usecase.CreateCompanyUseCase;
import com.teamstep.stepbackend.domain.company.application.usecase.GetCompanyListUseCase;
import com.teamstep.stepbackend.domain.company.application.usecase.GetCompanyUseCase;
import com.teamstep.stepbackend.domain.company.application.usecase.UpdateCompanyUseCase;
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

    // Create
    @PostMapping
    public ResponseEntity<CompanyCreateResponseDto> createCompany(
            @Valid @RequestBody CompanyCreateRequestDto requestDto
    ) {
        CompanyCreateResponseDto response = createCompanyUseCase.createCompany(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Update
    @PutMapping("/{companyId}")
    public ResponseEntity<Void> updateCompany(
            @PathVariable String companyId, @Valid @RequestBody CompanyUpdateRequestDto requestDto
    ) {
        updateCompanyUseCase.updateCompany(companyId, requestDto);
        return ResponseEntity.ok().build();
    }

    // ListSearch
    @GetMapping
    public ResponseEntity<CompanyListSearchResponseDto> getCompanyList(
            @ModelAttribute CompanySearchRequestDto requestDto,
            @PageableDefault(size = 20) Pageable pageable
    ) {
        return ResponseEntity.ok(getCompanyListUseCase.getCompanyList(requestDto, pageable));
    }

    // DetailSearch
    @GetMapping("/{companyId}")
    public ResponseEntity<CompanyDetailSearchResponseDto> getCompanyDetail(
            @PathVariable String companyId
    ) {
        CompanyDetailSearchRequestDto companyDetailSearchRequestDto = new CompanyDetailSearchRequestDto(companyId);
        return ResponseEntity.ok(getCompanyUseCase.getCompanyById(companyDetailSearchRequestDto));
    }
}
