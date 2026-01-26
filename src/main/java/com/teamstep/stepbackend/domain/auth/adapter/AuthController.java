package com.teamstep.stepbackend.domain.auth.adapter;

import com.teamstep.stepbackend.domain.auth.application.LoginUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class AuthController {
    @Value("${auth.bsm.redirection-url}")
    private String authUrl;
    private final LoginUseCase loginUseCase;

    @GetMapping("/auth/oauth/bsm")
    public ResponseEntity<Void> restRedirect() {
        return ResponseEntity.status(HttpStatus.SEE_OTHER)
                .location(URI.create(authUrl))
                .build();
    }

    @GetMapping("/auth/oauth/bsm/login")
    public String oauth(@RequestParam("code") String authCode) {
        return loginUseCase.login(authCode);
    }

}
