package org.spring5samples.models;

public class Van implements IVehicle {
    
	
	
    @Override
	public void startVehicle() {
		// TODO Auto-generated method stub
		System.out.println("Start Van");
	}

	
	@Override
	public void stopVehicle() throws Exception{
		// TODO Auto-generated method stub
		System.out.println("Stop Van");
		throw new Exception("Exception happened in stopVehicle()");
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
