package com.teamstep.stepbackend.domain.recruitment.application.usecase;

import com.teamstep.stepbackend.domain.company.application.exception.CompanyNotFoundException;
import com.teamstep.stepbackend.domain.recruitment.application.repository.RecruitmentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@RequiredArgsConstructor
public class DeleteRecruitmentUseCase {

    private final RecruitmentRepository recruitmentRepository;

    @Transactional
    public void deleteRecruitment(String recruitmentId) {
        recruitmentRepository.findById(recruitmentId)
                .orElseThrow(() -> new CompanyNotFoundException("해당 공고가 존재하지 않습니다."));

        recruitmentRepository.deleteById(recruitmentId);
    }
}
