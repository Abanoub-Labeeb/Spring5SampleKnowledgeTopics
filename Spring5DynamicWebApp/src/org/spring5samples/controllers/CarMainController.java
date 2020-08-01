package org.spring5samples.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.spring5samples.models.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CarMainController {
    /*Will be called via the main URL*/
	/*
	 * Test Will Be done by calling 
	 * - Main URL
	 * - MainURL/submitcarfull
	*/
	
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
	
	
	//Specifying from exactly which type of request we will process the request
	@GetMapping("/submitcarfull")
	public ModelAndView submitCarFull() {
		ModelAndView modelAndView = buildFullCarViewModelAndDynamicControls(null);	
		return modelAndView;
	}
	
	@PostMapping("/viewcarfull")
	public ModelAndView viewCarFull(@ModelAttribute Car car) {
		/*
		 * even if you didnot put @ModelAttribute the spring will identify it as it's the one
		 * coming from the submitted form
		 */
		
		ModelAndView modelAndView = new ModelAndView("ViewCarFull");
		modelAndView.addObject("car",car);
		return modelAndView;
	}
	
	/*
	* making use of hibernate validator by adding - @Valid ,BindingResult
	* redirect to the same form and populate it with previous results in case of error
	* next is showing error messages if value entered against the validation on the annotation on the Model class
	* we are making use of showing errors on the JSP page elements via using next 2 :
	* on this function add @ModelAttribute("car") 
	* add SubmitFullCar.jsp >> <form:errors path="name of field bounded to form ele. we want to validate">
	* by using these 2 this will enable showing error messages on the controls 
	* form:errors : show standard message or the message from the annotation above the field in the Model class 
	*               so if there is any errors attached to that field in this Car model send to the form bounded to Model attr. car this control will show the error
	*                 
	*/
	@PostMapping("/hibernatevalidateandviewcarfull")
	public ModelAndView hibernateValidateAndViewCarFull(@ModelAttribute("car") @Valid Car car,BindingResult result) {
		ModelAndView modelAndView;
		if(result.hasErrors()) {
			System.out.println("Error in the result !");
			//redirect to the same form and populate it with previous results in case of error
			modelAndView = buildFullCarViewModelAndDynamicControls(car);
		}else {
			modelAndView = new ModelAndView("ViewCarFull");
			modelAndView.addObject("car",car);	
		}
		
		return modelAndView;
	}

	
	//Make use of model map
	@GetMapping("/submitcarfull2")
	public String submitCarFull2(ModelMap modelMap) {
         
		
		Car car = new Car();
		//the Model is going to be passed to the view and will be bounded with a form using it's name modelAttribute="car"
		modelMap.addAttribute("car",car);
		//create radio buttons dynamically from queried values
		Map<String , String> engines = new HashMap<String,String>();
		engines.put("1200 CC", "1200 CC");
		engines.put("1600 CC", "1600 CC");
		modelMap.addAttribute("engines",engines);
		
		//create drop down dynamically from queried values
		Map<String , String> wheelPos = new HashMap<String,String>();
		//            Value , Label
		wheelPos.put("Left", "Left");
		wheelPos.put("Right", "Right");
		modelMap.addAttribute("wheelpos",wheelPos);
				
		//create checkboxes dynamically from queried values
		Map<String , String> paidOpts = new HashMap<String,String>();
		paidOpts.put("SubWover", "Sub-Wover");
		paidOpts.put("FlashLights", "Flash-Lights");
		modelMap.addAttribute("paidoptions",paidOpts);
		
		return "SubmitCarFull";
	}
	
	/********** Help Functions*************/
	public  ModelAndView buildFullCarViewModelAndDynamicControls(Car car) {
		ModelAndView modelAndView = new ModelAndView("SubmitCarFull");
		
		if(car == null) {
			car = new Car();
		}
		
		//the Model is going to be passed to the view and will be bounded with a form using it's name modelAttribute="car"
		modelAndView.addObject("car",car);
		//create radio buttons dynamically from queried values
		Map<String , String> engines = new HashMap<String,String>();
		engines.put("1200 CC", "1200 CC");
		engines.put("1600 CC", "1600 CC");
		modelAndView.addObject("engines",engines);
		
		//create drop down dynamically from queried values
		Map<String , String> wheelPos = new HashMap<String,String>();
		//            Value , Label
		wheelPos.put("Left", "Left");
		wheelPos.put("Right", "Right");
		modelAndView.addObject("wheelpos",wheelPos);
				
		//create checkboxes dynamically from queried values
		Map<String , String> paidOpts = new HashMap<String,String>();
		paidOpts.put("SubWover", "Sub-Wover");
		paidOpts.put("FlashLights", "Flash-Lights");
		modelAndView.addObject("paidoptions",paidOpts);
		
		return modelAndView;
	}
	/********** End *************/
}
