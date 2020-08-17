package org.spring5samples.models;

import org.springframework.beans.factory.annotation.Autowired;

public class Vehicles {

	@Autowired
	private Car car;
	
	@Autowired
	private Van van;
	
	
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Van getVan() {
		return van;
	}
	public void setVan(Van van) {
		this.van = van;
	}
	
}
