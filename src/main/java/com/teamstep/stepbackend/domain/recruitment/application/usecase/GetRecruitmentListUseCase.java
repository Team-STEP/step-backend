package com.teamstep.stepbackend.domain.recruitment.application.usecase;

import com.teamstep.stepbackend.domain.recruitment.application.dto.request.RecruitmentListSearchRequestDto;
import com.teamstep.stepbackend.domain.recruitment.application.dto.response.RecruitmentListSearchResponseDto;
import com.teamstep.stepbackend.domain.recruitment.application.dto.response.RecruitmentSearchResponseDto;
import com.teamstep.stepbackend.domain.recruitment.application.repository.RecruitmentRepository;
import com.teamstep.stepbackend.domain.recruitment.entity.Recruitment;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetRecruitmentListUseCase {

    private final RecruitmentRepository recruitmentRepository;

    @Transactional(readOnly = true)
    public RecruitmentListSearchResponseDto getRecruitmentList(
            RecruitmentListSearchRequestDto filter
    ) {
        Specification<Recruitment> spec = ((root, query, criteriaBuilder) -> criteriaBuilder.conjunction());

        if (filter.companyName() != null && !filter.companyName().isBlank()) {
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.like(root.get("companyName").as(String.class), "%" + filter.companyName() + "%"));
        }
        if (filter.location() != null && !filter.location().isBlank()) {
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("location"), filter.location()));
        }
        if (filter.area() != null && !filter.area().isBlank()) {
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("area"), filter.area()));
        }

        List<Recruitment> recruitmentList = recruitmentRepository.findAll(spec);
        List<RecruitmentSearchResponseDto> recruitments = recruitmentList.stream().map(RecruitmentSearchResponseDto::from).toList();
        return RecruitmentListSearchResponseDto.of(Long.valueOf(recruitments.size()), recruitments);
    }
}
