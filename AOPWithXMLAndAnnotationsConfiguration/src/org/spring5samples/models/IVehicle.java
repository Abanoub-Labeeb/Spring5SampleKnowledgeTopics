package org.spring5samples.models;

public interface IVehicle {

	public void startVehicle();
	
	public void stopVehicle() throws Exception;
	
	public void startCaset();
	
	public void startCaset(int volume);
}
