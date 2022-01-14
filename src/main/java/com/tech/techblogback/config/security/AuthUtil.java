package com.tech.techblogback.config.security;

import org.springframework.security.core.context.SecurityContextHolder;

public class AuthUtil {
    public static SystemUser getSystemUser() {
        try {
            return ((SystemUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        } catch (Exception e) {
            return null;
        }
    }
    public static Long getUserId() {
        try {
            return ((SystemUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        } catch (Exception e) {
            return null;
        }
    }

    public static String getUserEmail() {
        if (SecurityContextHolder.getContext() == null || SecurityContextHolder.getContext().getAuthentication() == null
                || "anonymousUser".equals(SecurityContextHolder.getContext().getAuthentication().getPrincipal())) {
            return null;
        }
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

}

