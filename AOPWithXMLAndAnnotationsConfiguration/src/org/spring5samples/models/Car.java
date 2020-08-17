package org.spring5samples.models;

public class Car implements IVehicle {

	@Override
	public void startVehicle() {
		// TODO Auto-generated method stub
		System.out.println("Start Car");
	}

	
	@Override
	public void stopVehicle() {
		// TODO Auto-generated method stub
		System.out.println("Stop Car");
	}
	
	@Override
	public void startCaset() {
		// TODO Auto-generated method stub
		System.out.println("Start Caset");
	}
		
	@Override
	public void startCaset(int volume) {
		// TODO Auto-generated method stub
		System.out.println("Start Caset at volume : "+ volume);
	}
}
