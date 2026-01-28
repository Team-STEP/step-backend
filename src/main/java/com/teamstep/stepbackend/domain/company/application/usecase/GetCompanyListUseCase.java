package com.teamstep.stepbackend.domain.company.application.usecase;

import com.teamstep.stepbackend.domain.company.application.dto.request.CompanySearchRequestDto;
import com.teamstep.stepbackend.domain.company.application.dto.response.CompanyListSearchResposneDto;
import com.teamstep.stepbackend.domain.company.application.dto.response.CompanySearchResponseDto;
import com.teamstep.stepbackend.domain.company.application.repository.CompanyRepository;
import com.teamstep.stepbackend.domain.company.entity.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetCompanyListUseCase {

    private final CompanyRepository companyRepository;

    @Transactional(readOnly = true)
    public CompanyListSearchResposneDto getCompanyList(
            CompanySearchRequestDto filter,
            Pageable pageable
    ) {
        Specification<Company> spec = (root, query, criteriaBuilder) -> criteriaBuilder.conjunction();

        if (filter.companyName() != null && !filter.companyName().isBlank()) {
            spec = spec.and(((root, query, criteriaBuilder) ->
                    criteriaBuilder.like(root.get("companyName").as(String.class), "%" + filter.companyName() + "%")));
        }
        if (filter.location() != null && !filter.location().isBlank()) {
            spec = spec.and(((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("location"), filter.location())));
        }
        if (filter.area() != null && !filter.area().isBlank()) {
            spec = spec.and(((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("area"), filter.area())));
        }

        Page<Company> companyPage = companyRepository.findAll(spec, pageable);
        List<CompanySearchResponseDto> companyDtoList = companyPage.getContent().stream().map(CompanySearchResponseDto::from).toList();
        return CompanyListSearchResposneDto.of(companyPage.getTotalElements(), companyDtoList);
    }
}
