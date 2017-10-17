package com.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

@Component("tokenDetailsSource")
public class TokenDetailSource extends WebAuthenticationDetailsSource {

    @Override
    public WebAuthenticationDetails buildDetails(HttpServletRequest context) {
        return new TokenDetails(context);
    }
}

