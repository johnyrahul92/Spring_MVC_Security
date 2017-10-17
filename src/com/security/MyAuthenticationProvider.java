package com.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		
		String name= authentication.getName();
		String credentials = authentication.getCredentials().toString();
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		//authorities.add(new SimpleGrantedAuthority ("ROLE_ADMIN"));
		authorities.add(new SimpleGrantedAuthority ("ROLE_USER"));
		/*
		authentication.setAuthenticated(true);
		
		authentication.isAuthenticated();*/
	
		
		
		return new UsernamePasswordAuthenticationToken(name, credentials,authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		 return authentication.equals(
		          UsernamePasswordAuthenticationToken.class);
	}

	
	

}
