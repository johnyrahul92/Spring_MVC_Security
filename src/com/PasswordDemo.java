package com;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordDemo {
	
	public String getMD5Hash(String plainText) {
		
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		String encrypted =  encoder.encodePassword(plainText, null);
		
		System.out.println("Plain text : "+plainText);
		System.out.println("encrypted : "+encrypted);
		
		 
		
		return encrypted;
	}
	
	 @CacheEvict(value = "test", allEntries=true)
	public void clearCache(int id) {
		 
		 System.out.println("Cleared the cache for Id" + id);
		
		
		
	}

}
