package com.teamstep.stepbackend.domain.recruitment.application.usecase;

import com.teamstep.stepbackend.domain.company.application.exception.RecruitmentNotFoundException;
import com.teamstep.stepbackend.domain.recruitment.application.dto.request.RecruitmentDetailSearchRequestDto;
import com.teamstep.stepbackend.domain.recruitment.application.dto.response.RecruitmentDetailSearchResponseDto;
import com.teamstep.stepbackend.domain.recruitment.application.repository.RecruitmentRepository;
import com.teamstep.stepbackend.domain.recruitment.entity.Recruitment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GetRecruitmentUseCase {

    private final RecruitmentRepository recruitmentRepository;

    @Transactional(readOnly = true)
    public RecruitmentDetailSearchResponseDto getRecruitment(RecruitmentDetailSearchRequestDto recruitmentId) {
        Recruitment recruitment = recruitmentRepository.findById(recruitmentId.id())
                .orElseThrow(() -> new RecruitmentNotFoundException("해당 공고가 존재하지 않습니다."));

        return RecruitmentDetailSearchResponseDto.from(recruitment);
    }
}
