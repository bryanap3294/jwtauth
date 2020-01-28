package com.bryan.promopack.jwtToken.service;

import org.springframework.security.core.Authentication;

public interface CustomAuthenticationService {

    Authentication customToken(Authentication authentication);

}
