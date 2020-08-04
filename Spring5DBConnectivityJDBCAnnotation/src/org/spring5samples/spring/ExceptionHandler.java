package org.spring5samples.spring;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
	
	/*this annotation accept the exception type*/
	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception ex) {
		/*
		 * this handler will even catch compile time errors not just runtime errors
		 * can be added  in a separate class like in here
		 * or per controller as in MainController
		 * * if both exists the one in the MainController will take the priority and will be called
		 */
		
		//log the exception on your files or do custom logic here
		
		//return the custom error page here
		System.out.println("exceptionHandler in ExceptionHandler called");
		return "Error";
	}
}
