package com.teamstep.stepbackend.domain.auth.adapter.controller;

import com.teamstep.stepbackend.domain.auth.adapter.dto.request.AuthLoginResponseDto;
import com.teamstep.stepbackend.domain.auth.application.exception.AccountNotFoundException;
import com.teamstep.stepbackend.domain.auth.application.exception.BsmOAuthAuthorizationException;
import com.teamstep.stepbackend.domain.auth.application.usecase.LoginUseCase;
import com.teamstep.stepbackend.global.exception.ServerEnvironmentException;
import leehj050211.bsmOauth.exception.BsmOAuthInvalidClientException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth/oauth/bsm")
public class AuthController {
    @Value("${auth.bsm.redirection-url}")
    private String authUrl;
    private final LoginUseCase loginUseCase;

    @GetMapping("")
    public ResponseEntity<Void> restRedirect() {
        return ResponseEntity
                .status(HttpStatus.SEE_OTHER)
                .location(URI.create(authUrl))
                .build();
    }

    @GetMapping("/login")
    public ResponseEntity oauth(@RequestParam("code") String authCode) {
        try {
            AuthLoginResponseDto dto = new AuthLoginResponseDto(loginUseCase.login(authCode));
            return ResponseEntity
                    .ok()
                    .body(dto);
        } catch (AccountNotFoundException | BsmOAuthAuthorizationException e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(e.getMessage());
        } catch (BsmOAuthInvalidClientException | ServerEnvironmentException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

}
