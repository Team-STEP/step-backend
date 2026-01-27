package com.teamstep.stepbackend.domain.company.adapter.controller;

import com.teamstep.stepbackend.domain.company.application.dto.request.CompanyCreateRequestDto;
import com.teamstep.stepbackend.domain.company.application.dto.request.CompanyUpdateRequestDto;
import com.teamstep.stepbackend.domain.company.application.dto.response.CompanyCreateResponseDto;
import com.teamstep.stepbackend.domain.company.application.usecase.CreateCompanyUseCase;
import com.teamstep.stepbackend.domain.company.application.usecase.UpdateCompanyUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// PreAuthorize
@RestController
@RequiredArgsConstructor
@RequestMapping("/companies")
public class CompanyController{

    private final CreateCompanyUseCase createCompanyUseCase;
    private final UpdateCompanyUseCase updateCompanyUseCase;

    // Write
    @PostMapping("/companies")
    public ResponseEntity<CompanyCreateResponseDto> createCompany(
            @Valid @RequestBody CompanyCreateRequestDto requestDto
    ) {
        CompanyCreateResponseDto response = createCompanyUseCase.createCompany(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/companies/{company-id}")
    public void updateCompany(
            @Valid @RequestParam String id, @RequestBody CompanyUpdateRequestDto requestDto
    ){
        updateCompanyUseCase.updateCompany(id, requestDto);
    }

    // Read
    // ListSearch
    // DetailSearch
}
