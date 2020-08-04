package org.spring5samples.controllers;

import java.util.List;

import org.spring5samples.DAOs.SecurityDAOImpl;
import org.spring5samples.models.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping("/")
	public ModelAndView Index() {
		ModelAndView modelAndView = new ModelAndView("Index");	
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/org/spring5samples/DAOs/Spring-DAOConfig.xml");
		
		//SecurityDAOBean : is the bean id instantiated and defined in /org/spring5samples/DAOs/Spring-DAOConfig.xml
		SecurityDAOImpl securityDAOImpl = context.getBean("SecurityDAOBean",SecurityDAOImpl.class);
		List<User> users = securityDAOImpl.getAllUsers();
		
		modelAndView.addObject("users",users);
		
		context.close();
		
		return modelAndView;
	}
	
	
}
