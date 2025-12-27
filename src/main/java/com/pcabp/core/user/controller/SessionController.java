package com.pcabp.core.user.controller;

import com.pcabp.core.user.vo.SessionUser;
import com.pcabp.helper.SessionHolder;
import com.pcabp.model.RestResponse;
import com.pcabp.session.SessionUserDetails;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

@Tag(name = "세션 API", description = "세션 API 입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/user/session")
public class SessionController {

    @Operation(summary = "세션 정보 조회", description = "세션 정보를 조회합니다.")
    @GetMapping
    public RestResponse<SessionUser> getSession() {
        SessionUserDetails sessionUserDetails = SessionHolder.getSessionUser();
        SessionUser sessionUser = sessionUserDetails.toSessionUser();
        return RestResponse.ofSuccess(sessionUser);
    }
}
