package com.teamstep.stepbackend.domain.auth.application.usecase;

import com.teamstep.stepbackend.domain.auth.application.exception.AccountNotFoundException;
import com.teamstep.stepbackend.domain.auth.application.exception.BsmOAuthAuthorizationException;
import com.teamstep.stepbackend.domain.auth.application.repository.AuthRepository;
import com.teamstep.stepbackend.domain.auth.entity.Account;
import com.teamstep.stepbackend.global.exception.ServerEnvironmentException;
import com.teamstep.stepbackend.global.tool.JwtTool;
import leehj050211.bsmOauth.BsmOauth;
import leehj050211.bsmOauth.dto.resource.BsmUserResource;
import leehj050211.bsmOauth.exception.BsmOAuthCodeNotFoundException;
import leehj050211.bsmOauth.exception.BsmOAuthInvalidClientException;
import leehj050211.bsmOauth.exception.BsmOAuthTokenNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginUseCase {
    private final BsmOauth bsmOauth;
    private final AuthRepository authRepository;
    private final JwtTool jwtManager;

    @Transactional(readOnly = true, timeout = 2)
    public String login(
            String authCode
    ) throws AccountNotFoundException, BsmOAuthAuthorizationException, BsmOAuthInvalidClientException, ServerEnvironmentException {
        String email = this.getEmailFromBsm(authCode);
        Optional<Account> account = authRepository.findAccountByEmail(email);
        if (account.isEmpty()) throw new AccountNotFoundException();
        return jwtManager.createToken(account.get().getOwnerName());
    }

    private String getEmailFromBsm(
            String authCode
    ) throws BsmOAuthAuthorizationException, BsmOAuthInvalidClientException, ServerEnvironmentException {
        BsmUserResource resource = this.getBsmUserResource(authCode);
        return resource.getEmail();
    }

    private BsmUserResource getBsmUserResource(
            String authCode
    ) throws BsmOAuthAuthorizationException, BsmOAuthInvalidClientException, ServerEnvironmentException {
        try {
            String token = bsmOauth.getToken(authCode);
            return bsmOauth.getResource(token);
        } catch (IOException e) {
            throw new ServerEnvironmentException("서버의 네트워크에 문제가 발생했습니다. (from auth/login)");
        } catch (BsmOAuthCodeNotFoundException | BsmOAuthTokenNotFoundException e) {
            throw new BsmOAuthAuthorizationException(e.getMessage());
        }
    }

}
