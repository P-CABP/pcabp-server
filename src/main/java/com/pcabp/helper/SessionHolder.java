package com.pcabp.helper;

import com.pcabp.session.SessionUserDetails;

import org.springframework.security.core.context.SecurityContextHolder;

import lombok.experimental.UtilityClass;

@UtilityClass
public class SessionHolder {

    public static boolean isAuthenticated() {
        Object principal =
                SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return !principal.equals("anonymousUser");
    }

    public static SessionUserDetails getSessionUser() {
        return (SessionUserDetails)
                SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public static String getUsername() {
        return getSessionUser().getUsername();
    }
}
