package com.teamstep.stepbackend.domain.auth.application;

import com.teamstep.stepbackend.domain.auth.entity.Account;
import com.teamstep.stepbackend.global.tool.JwtManager;
import leehj050211.bsmOauth.BsmOauth;
import leehj050211.bsmOauth.dto.resource.BsmUserResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginUseCase {
    private final BsmOauth bsmOauth;
    private final AuthRepository authRepository;
    private final JwtManager jwtManager;

    public String login(String authCode) {
        BsmUserResource resource = this.getResource(authCode);
        if (resource == null) return "";
        Account account = authRepository.findAccountByEmail(resource.getEmail());
        if (account == null) return "";
        return jwtManager.createToken(account.getOwnerName());
    }

    private BsmUserResource getResource(String authCode) {
        try {
            String token = bsmOauth.getToken(authCode);
            return bsmOauth.getResource(token);
        } catch (Exception e) {
            return null;
        }
    }

}
