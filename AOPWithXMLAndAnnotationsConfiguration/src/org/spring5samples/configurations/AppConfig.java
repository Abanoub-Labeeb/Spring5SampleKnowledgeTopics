package org.spring5samples.configurations;

import org.spring5samples.BusinessLogic.*;
import org.spring5samples.models.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/*
 * Understanding Proxy Object :
 *  
 * note : Car , or Van Impl. the interface IVehicle next exception happen and the diagnose not executed
 * org.springframework.beans.factory.BeanNotOfRequiredTypeException: Bean named 'car' is expected to be of type 'org.spring5samples.models.Car' but was actually of type 'com.sun.proxy.$Proxy284'
 * 
 * Reason : 
 * in MainController/annotationTest function 
 		* when you call >> MotorBike motorBike= context.getBean("motorBike",MotorBike.class);
 		* or       call >> Vehicles vehicles= context.getBean("vehicles",Vehicles.class);  
 *  
	  * in MotorBike case it try request MotorBike object by getting the instantiate bean object according Config inside the AppConfig.java 
 * in Vehicles  case it try to instantiate Car object [in the properties] by the Autowire   
 * but in both because there is events to be exected before and after
 * Proxy object will be returned (Proxy Object : is the normal Car object plus calls for Before/After/... events inside the object's function)
 *
 *     
 * Solutions :
 * 1- put (proxyTargetClass = true) inside AppConfig.java >>  @EnableAspectJAutoProxy(proxyTargetClass = true)
 *    this tells AOP to return the target class and execute the events in separate obj.
 *    
 * 2- this solution work only for MotorBike Case not the autowire "not effective"
 *    make it like next IVehicle motorBike= context.getBean("motorBike",Vehicle.class);
 *    but the interface has to contain abstract methods of all methods inside MotorBike class       
*/

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {

	@Bean("car")
	public Car car() {
		return new Car();
	}
	
	@Bean("van")
	public Van van() {
		return new Van();
	}
	
	@Bean("vehicles")
	public Vehicles vehicles() {
		return new Vehicles();
	}
	
	@Bean("vehicleDiagnostic")
	public VehicleDiagnostic vehicleDiagnostic() {
		/*this is the aspect class which contain advice to be executed*/
		return new VehicleDiagnostic();
	}
	
	@Bean("motorBike")
	public MotorBike motorBike() {
		return new MotorBike();
	}
	
	@Bean("electricBike")
	public ElectricBike electricBike() {
		return new ElectricBike();
	}
	
	@Bean("electricVan")
	public ElectricVan electricVan() {
		return new ElectricVan();
	}
}
