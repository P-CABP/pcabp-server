package com.pcabp.core.user.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import com.pcabp.core.user.vo.SessionUser;
import com.pcabp.helper.SessionHolder;
import com.pcabp.model.RestResponse;
import com.pcabp.session.SessionUserDetails;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

@Tag(name = "Session API", description = "Session API Endpoints")
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/session")
public class SessionController {

    @Operation(summary = "세션 조회", description = "세션을 조회합니다.")
    @GetMapping
    public RestResponse<SessionUser> getSession() {
        if (SessionHolder.isAuthenticated()) {
            SessionUserDetails sessionUserDetails = SessionHolder.getSessionUser();
            SessionUser sessionUser = sessionUserDetails.toSessionUser();
            return RestResponse.ofSuccess(sessionUser);
        }

        return RestResponse.ofSuccess(null);
    }

    @Operation(summary = "세션 삭제", description = "세션을 삭제합니다.")
    @DeleteMapping
    public RestResponse<Boolean> deleteSession(HttpServletRequest request) {
        SecurityContextHolder.clearContext();

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        return RestResponse.ofSuccess(true);
    }
}
