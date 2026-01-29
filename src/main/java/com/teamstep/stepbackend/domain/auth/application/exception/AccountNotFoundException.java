package com.teamstep.stepbackend.domain.auth.application.exception;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException() {
        super("해당하는 사용자의 계정을 찾지 못했습니다.");
    }
}
