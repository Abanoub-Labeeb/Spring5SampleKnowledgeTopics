package org.spring5sampledemos.nonpersistent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Component name Component("toyota") : all letters must be in lower case
//if you removed ("toyota") ,it will still work 
//as by spring convension the name of the component is same name as class but in small letters except if you want to add another name
//Now by @Component , this class is considered a bean which can be instantiated via spring when scanning for the components

@Component("toyota")
public class Toyota implements ICar{


	//@Autowired : this key word to invert the control to spring framework to take an instance and inject it in here 
	//             this will call the default constructor automatically
	//@Autowired : give us proper logs on crushes
	//@Autowired(required = false) : if we passed false to the @Autowired annotation constructor , the instance will be only created if it's used in here
	//                               this is a way of optimizing the memory 
	@Autowired
	Engine engine;
	
	
	//Q:in the above Autowired property spring will call the default constructor and this is the default behaviour
	//what if we want to create overloaded Constuctor on Engine , passing some default values on instantiation
	//Ans. : we will use method Autowiring
	//we will create a method to pass the values to the Engine properties via setters in here 
	//and it will be called automatically by spring FW
	@Autowired
	public void setEngine(Engine engine) {
		engine.setDefaultHoursePower("1800 CC");
		this.engine = engine;
	}
	
	@Override
	public String spects() {
		// TODO Auto-generated method stub
		return "Toyota with defualt hourse power : " + engine.getDefaultHoursePower();
	}

}
