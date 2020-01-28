package com.bryan.promopack.jwtToken.service.impl;

import com.bryan.promopack.jwtToken.model.User;
import com.bryan.promopack.jwtToken.repository.UserRepository;
import com.bryan.promopack.jwtToken.service.CustomAuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomAuthenticationServiceImpl implements CustomAuthenticationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomAuthenticationServiceImpl.class);

    @Autowired
    protected UserRepository userRepository;

    @Override
    public Authentication customToken(Authentication authentication) {
        String userName = (String)authentication.getPrincipal();
        String password = (String)authentication.getCredentials();
        User user = userRepository.findByUsernameAndPassword(userName, password);
        if(user!=null){
            return new UsernamePasswordAuthenticationToken(userName, password, Collections.emptyList());
        }else{
            return null;
        }
    }

}
