package com.teamstep.stepbackend.domain.company.application.exception;

public class RecruitmentNotFoundException extends RuntimeException {
    public RecruitmentNotFoundException(String message) {
        super(message);
    }
}
