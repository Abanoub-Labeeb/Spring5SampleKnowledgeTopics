package org.spring5samples.models;

public class Car {
    String model;
    String type;
    
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

	@Override
	public String toString() {
		return "Car [model=" + model + ", type=" + type + "]";
	}
    
}
