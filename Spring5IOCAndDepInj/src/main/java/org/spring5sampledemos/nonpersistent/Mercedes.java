package org.spring5sampledemos.nonpersistent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//start with the notes from toyota class

@Component("mercedes")
public class Mercedes implements ICar{

	Engine engine;
	
	//we can Autowire the engine property and intialize it with values 
	//both together in one shot in the constructor of the current class , remove the @Autowired from the Engine Property too
	//@Autowired(required = false) : don't use that in here as the constructor will be always called
	//Note :  if you removed @Autowired from the constructor and put it to the Engine property , the constructor will be still called anyway
	@Autowired
	public Mercedes(Engine engine) {
		engine.setDefaultHoursePower("2200 CC");
		this.engine = engine;
	}
	
	
	@Override
	public String spects() {
		// TODO Auto-generated method stub
		return "Mercedes with defualt hourse power : " + engine.getDefaultHoursePower();
	}

}
