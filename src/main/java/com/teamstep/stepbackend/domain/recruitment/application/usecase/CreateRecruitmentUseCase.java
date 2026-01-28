package com.teamstep.stepbackend.domain.recruitment.application.usecase;

import com.teamstep.stepbackend.domain.recruitment.application.dto.request.RecruitmentCreateRequestDto;
import com.teamstep.stepbackend.domain.recruitment.application.dto.response.RecruitmentCreateResponseDto;
import com.teamstep.stepbackend.domain.recruitment.application.repository.RecruitmentRepository;
import com.teamstep.stepbackend.domain.recruitment.entity.Recruitment;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateRecruitmentUseCase {

    private final RecruitmentRepository recruitmentRepository;

    @Transactional
    public RecruitmentCreateResponseDto createRecruitment(RecruitmentCreateRequestDto requestDto){
        Recruitment recruitment = requestDto.toEntity();
        Recruitment savedRecruitment = recruitmentRepository.save(recruitment);
        return RecruitmentCreateResponseDto.from(savedRecruitment);
    }
}
