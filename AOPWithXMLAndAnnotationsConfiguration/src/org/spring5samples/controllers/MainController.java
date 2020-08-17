package org.spring5samples.controllers;

import org.spring5samples.BusinessLogic.AccountOperations;
import org.spring5samples.configurations.AppConfig;
import org.spring5samples.models.ElectricBike;
import org.spring5samples.models.ElectricVan;
import org.spring5samples.models.IElectricVehicle;
import org.spring5samples.models.MotorBike;
import org.spring5samples.models.Vehicles;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String index() {
	/*AOP with XML configuration example*/
		
	ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("/org/spring5samples/configurations/Beans-Configuration.xml");
	
	//in the case of AOP : accountOperations is not the normal bean instantiated 
	//but it's a proxy object which contains call to the advice based on the configuration
	AccountOperations accountOperations = context.getBean("AccountOperations",AccountOperations.class);
	accountOperations.withdraw();
	
	context.close();
	return "Index";
	}
	
	
	@RequestMapping("/annotationtest")
	public String annotationTest() {
	/*AOP with Annotation configuration example*/
		
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	Vehicles vehicles= context.getBean("vehicles",Vehicles.class);
	
	vehicles.getCar().startVehicle();
	vehicles.getCar().startCaset();
	vehicles.getCar().startCaset(5);
	vehicles.getCar().stopVehicle();
	
	vehicles.getVan().startVehicle();
	
	try {
		vehicles.getVan().stopVehicle();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}
	
	MotorBike motorBike= context.getBean("motorBike",MotorBike.class);
	
	motorBike.getColor();
	motorBike.getWheelColor("Green");
	motorBike.getMotorColor("Red", "Green", "Blue");
	motorBike.getMotorCCs(1, 2, 3);
	
    ElectricBike electricBike= context.getBean("electricBike",ElectricBike.class);
	
    electricBike.getColor();
	
    ElectricVan electricVan= context.getBean("electricVan",ElectricVan.class);
	
    electricVan.getColor();
    
	context.close();
	return "Index";
	}
}
