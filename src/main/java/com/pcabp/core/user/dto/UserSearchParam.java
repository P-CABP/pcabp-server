package com.pcabp.core.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSearchParam {

    @Schema(description = "사용자명", example = "codesver")
    private String username;

    public static UserSearchParam ofUsername(String username) {
        return UserSearchParam.builder().username(username).build();
    }
}
