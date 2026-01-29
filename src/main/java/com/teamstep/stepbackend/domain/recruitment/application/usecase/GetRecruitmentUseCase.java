package com.teamstep.stepbackend.domain.recruitment.application.usecase;

import org.springframework.transaction.annotation.Transactional;

public class GetRecruitmentUseCase {
    @Transactional(readOnly = true)
    public Recruitment getRecruitment() {}
}
