package org.spring5samples.models;

public interface IElectricVehicle {

	public void startVehicle();
	
	public void stopVehicle() throws Exception;
	
	public void startCaset();
	
	public void startCaset(int volume);
}
