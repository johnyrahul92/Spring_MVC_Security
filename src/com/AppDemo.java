package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*ApplicationContext context = new ClassPathXmlApplicationContext("TestContext.xml");*/
		
		
	//	PasswordDemo demo = context.getBean("passwordDemo",PasswordDemo.class);
		
		
		PasswordDemo demo = new PasswordDemo();
		demo.getMD5Hash("johny");

		demo.clearCache(0);
		//((ClassPathXmlApplicationContext) context).close();
		
		
		

	}

}
