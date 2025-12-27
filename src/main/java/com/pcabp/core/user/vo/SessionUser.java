package com.pcabp.core.user.vo;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SessionUser {

    @Schema(description = "사용자명", example = "codesver")
    private String username;

    @Schema(description = "권한 목록")
    private List<String> authorities;
}
