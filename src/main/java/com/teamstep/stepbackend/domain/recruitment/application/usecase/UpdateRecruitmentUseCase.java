package com.teamstep.stepbackend.domain.recruitment.application.usecase;

import com.teamstep.stepbackend.domain.company.application.exception.CompanyNotFoundException;
import com.teamstep.stepbackend.domain.recruitment.application.dto.request.RecruitmentUpdateRequestDto;
import com.teamstep.stepbackend.domain.recruitment.application.repository.RecruitmentRepository;
import com.teamstep.stepbackend.domain.recruitment.entity.Recruitment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateRecruitmentUseCase {

    private final RecruitmentRepository recruitmentRepository;

    public void updateRecruitment(String recruitmentId, RecruitmentUpdateRequestDto requestDto){
        recruitmentRepository.findById(recruitmentId)
                .orElseThrow(() -> new CompanyNotFoundException("해당 공고가 존재하지 않습니다."));

        Recruitment recruitment = requestDto.toEntity(recruitmentId);
        recruitmentRepository.save(recruitment);
    }
}
