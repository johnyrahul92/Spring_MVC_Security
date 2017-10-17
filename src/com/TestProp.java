package com;

import org.springframework.beans.factory.annotation.Value;

public class TestProp {
	
	@Value("${testprop}")
	private static String enetEndpoint;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hi");
		System.out.println(enetEndpoint);

	}

}
