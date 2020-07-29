package org.spring5samples.controllers;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.spring5samples.models.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CarMainController {
    /*Will be called via the main URL*/
	
	
	//Main Method to be called on that controller
	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public String mainWelcome() {
		//return the Name of the view to be rendered
		//The CarMainServlet Dispatcher Servlet is defined in Web.xml >> CArMainServlet-servlet.xml 
		//to scan for that page "View" in WebContent/WEB-PAGES/
		//and to scan and instantiate beans from org.spring5samples packages 
		return "Main";
	}
	
	//default method is already RequestMethod.GET
	@RequestMapping("displayCarSubmitted")
	public String displayCarSubmitted(HttpServletRequest request) {
		String type      = request.getParameter("type"); 
		String bodyStyle = request.getParameter("style");
		
		request.setAttribute("type", type);
		request.setAttribute("style", bodyStyle);
		
		return "DisplaySubmittedCarBrief";
	}
	
	
	//exact same as the above function but the differences is 
	//we will get the parameters directly in the function input
	//we will pass the attributes using the Model object instead of passing them in the request
	@RequestMapping("displayCarSubmitted2")
	public String displayCarSubmitted2(@RequestParam("type") String type,@RequestParam("style") String bodyStyle , Model model) {
		
		model.addAttribute("type", type);
		model.addAttribute("style", bodyStyle);
		
		return "DisplaySubmittedCarBrief2";
	}
		
	//exact same as the above function but the differences is 
	//we will pass the View name  and attributes using the ModelAndView object instead of passing View Name as string and parameters in the Model
	@RequestMapping("displayCarSubmitted3")
	public ModelAndView displayCarSubmitted3(@RequestParam("type") String type,@RequestParam("style") String bodyStyle) {
		
		ModelAndView modelAndView = new ModelAndView("DisplaySubmittedCarBrief2");
		modelAndView.addObject("type", type);
		modelAndView.addObject("style", bodyStyle);
		
		Date today= new Date();
		modelAndView.addObject("today", today);
		
		ArrayList<Car> cars= new ArrayList<Car>();
		cars.add(new Car("Toyota","Sedan"));
		cars.add(new Car("Volkswagn","Hatchbag"));
		modelAndView.addObject("cars", cars);
		
		return modelAndView;
	}
}
