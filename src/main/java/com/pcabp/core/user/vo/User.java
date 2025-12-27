package com.pcabp.core.user.vo;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {

    @Schema(description = "사용자명", example = "codesver")
    private String username;

    @Schema(description = "비밀번호")
    private String password;

    @Schema(description = "권한 목록")
    private List<String> authorities;
}
