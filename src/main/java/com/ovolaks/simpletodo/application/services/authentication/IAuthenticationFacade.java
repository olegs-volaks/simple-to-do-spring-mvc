package com.ovolaks.simpletodo.application.services.authentication;

import org.springframework.security.core.Authentication;

public interface IAuthenticationFacade {
    Authentication getAuthentication();

    boolean isAuthenticated();
}
