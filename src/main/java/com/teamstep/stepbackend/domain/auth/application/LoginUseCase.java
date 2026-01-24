package com.teamstep.stepbackend.domain.auth.application;

import leehj050211.bsmOauth.BsmOauth;
import leehj050211.bsmOauth.dto.resource.BsmUserResource;
import leehj050211.bsmOauth.exception.BsmOAuthCodeNotFoundException;
import leehj050211.bsmOauth.exception.BsmOAuthInvalidClientException;
import leehj050211.bsmOauth.exception.BsmOAuthTokenNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class LoginUseCase {
    private final BsmOauth bsmOauth;

    public String oauth(String authCode) {
        String nickname = "";
        try {
            nickname = this.getUserNickname(authCode);
        } catch (BsmOAuthCodeNotFoundException e) {
            // 임시 인증코드를 찾을 수 없음
        } catch (BsmOAuthTokenNotFoundException e) {
            // 유저 토큰을 찾을 수 없음
        } catch (BsmOAuthInvalidClientException e) {
            // 클라이언트 ID 또는 시크릿이 잘못됨
        } catch (IOException e) {
            //
        }
        return nickname;
    }

    private String getUserNickname(String authCode) throws IOException, BsmOAuthInvalidClientException, BsmOAuthCodeNotFoundException, BsmOAuthTokenNotFoundException {
        String token = bsmOauth.getToken(authCode);
        BsmUserResource resource = bsmOauth.getResource(token);
        return resource.getNickname();
    }

}
