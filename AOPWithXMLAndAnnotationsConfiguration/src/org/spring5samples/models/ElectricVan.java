package org.spring5samples.models;

import org.springframework.stereotype.Component;


public class ElectricVan implements IElectricVehicle{
    
	public static int maxSpeed=100;
	
	public void getColor() {
		System.out.println("Color : Red");
	}
    
	public void getWheelColor(String color) {
		System.out.println("Color : " + color);
	}
	
	@Deprecated
	public void getMotorColor(String color1,String color2 ,String color3) {
		System.out.println("Color1 :  " + color1+" - Color2 : " + color2+" - Color3 : " + color3);
	}
	
	public void getMotorCCs(int cc1,int cc2 ,int cc3) {
		System.out.println("cc1 :  " + cc1+" - cc2 : " + cc2+" - cc3 : " + cc3);
	}

	@Override
	public void startVehicle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stopVehicle() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startCaset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startCaset(int volume) {
		// TODO Auto-generated method stub
		
	}
    
}
