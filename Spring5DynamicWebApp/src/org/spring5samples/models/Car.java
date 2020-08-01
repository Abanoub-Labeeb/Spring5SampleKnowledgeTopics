package org.spring5samples.models;

import javax.validation.constraints.Size;

public class Car {
	//@Size is a hibernate validator
	@Size(min = 3 , max = 10 ,message = "Enter value with minimum 3 characters and maximum 10 charachters!")
    String model;
    
	String type;
    String engine;
    String country;
    String wheelPos;
    String freeOptions[];
    String paidOptions[];
	String extraInfo;
    
	
	public Car() {
		super();
		this.model = "";
		this.type = "";
	}
    
	public Car(String model, String type) {
		super();
		this.model = model;
		this.type = type;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

    public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getWheelPos() {
		return wheelPos;
	}

	public void setWheelPos(String wheelPos) {
		this.wheelPos = wheelPos;
	}

    public String[] getFreeOptions() {
		return freeOptions;
	}

	public void setFreeOptions(String[] freeOptions) {
		this.freeOptions = freeOptions;
	}

	public String[] getPaidOptions() {
		return paidOptions;
	}

	public void setPaidOptions(String[] paidOptions) {
		this.paidOptions = paidOptions;
	}
	
	public String getExtraInfo() {
		return extraInfo;
	}

	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}

	
	@Override
	public String toString() {
		return "Car [model=" + model + ", type=" + type + "]";
	}

	
}
