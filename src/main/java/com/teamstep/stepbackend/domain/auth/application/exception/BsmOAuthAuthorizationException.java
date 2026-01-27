package com.teamstep.stepbackend.domain.auth.application.exception;

public class BsmOAuthAuthorizationException extends RuntimeException {
    public BsmOAuthAuthorizationException(String message) {
        super(message);
    }
}
