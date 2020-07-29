package org.spring5sampledemos.nonpersistent;

import org.springframework.stereotype.Component;

@Component("engine")
public class Engine {

	private String defaultHoursePower; 
	public Engine() {
		setDefaultHoursePower("1600 CC");
	}
	
	
	String getDefaultHoursePower() {
		return defaultHoursePower;
	}
	void setDefaultHoursePower(String defaultHoursePower) {
		this.defaultHoursePower = defaultHoursePower;
	}
	
	
}
