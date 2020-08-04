package org.spring5samples.controllers;

import java.util.List;

import javax.validation.Valid;

import org.spring5samples.DAOs.SecurityDAOImpl;
import org.spring5samples.models.User;
import org.spring5samples.spring.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("Index");	
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		//SecurityDAOBean : is the bean id instantiated and defined in AppConfig
		SecurityDAOImpl securityDAOImpl = context.getBean("SecurityDAOBean",SecurityDAOImpl.class);
		List<User> users = securityDAOImpl.getAllUsers();
		
		modelAndView.addObject("users",users);
		
		context.close();
		
		return modelAndView;
	}
	
	
	@RequestMapping("/adduser")
	public String addUser(Model model ,@Valid User user , BindingResult result) {
		/*
		 * When invocation via the hyperlink 
		 * spring will pass model object
		 * also spring will instantiate obj. from User and pass it to in here 
		 * so there must be a default constructor on the User class
		*/
		
		if(user.getName() == null && user.getEmail() == null) {
			return "AddUser";
		}else {
			if(result.hasErrors())
			{
				model.addAttribute("user",user);
				return "AddUser";
			}else {
				
		        //save user
				AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
			    //SecurityDAOBean : is the bean id instantiated and defined in AppConfig
				SecurityDAOImpl securityDAOImpl = context.getBean("SecurityDAOBean",SecurityDAOImpl.class);
				securityDAOImpl.addUser(user);
				context.close();
				
				
				//redirect to the home page
				return "forward:/";	
			}	
		}		
		
	}
	
	
	
	/*this annotation accept the exception type*/
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception ex) {
		/*
		 * this handler will even catch compile time errors not just runtime errors
		 * the exception handler can be added per controller like in here or
		 * can be added  in a separate class like ExceptionHandler that exist in  org.spring5samples.spring package
		 * if both exists the one in the MainController will take the priority and will be called
		*/
		
		//log the exception on your files or do custom logic here
		
		//return the custom error page here
		System.out.println("exceptionHandler in MainController called");
		return "Error";
	}
	
}
