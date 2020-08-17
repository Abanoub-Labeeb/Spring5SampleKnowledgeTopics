package org.spring5samples.BusinessLogic;

import java.lang.annotation.Target;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.spring5samples.models.MotorBike;

@Aspect
public class VehicleDiagnostic {

	/****************Defining anonymous pointcut ****************/
	
	@Before("execution(void startVehicle())")
	public void diagnose() {
		/*Advise method*/
		System.err.println("Vehicle diagnosed !");
	}
	
	//Note : you can restrict the advise method execution to happen when executing method inside specific class
	//Note : You can put both before and after above one advise
	@After("execution(void org.spring5samples.models.Car.startVehicle())")
	public void resultSubmit() {
		/*Advise method*/
		System.err.println("Car After Start : started successfully !");
	}
	
 	/****************Defining a named pointcut ****************/
	
	@Pointcut("execution(void org.spring5samples.models.Van.stopVehicle())")
	public void stopVan() {
		//startVehicle is the id of the pointcut
		//must be named exactly as the joinpoint name 
	}
	
	//Execution Seq : 1 then Van.stopVehicle() is 2
	@Before("stopVan()")
	public void preStopVehicle() {
		System.err.println("preStopVehicle : Van pre-stop !");
	}
    
	//Execution Seq : 4 then the exception handler will be executed  
	@After("stopVan()")
	public void postStopVehicle() {
		/*will be executed even if exception happened in Van.stopVehicle() execution*/
		System.err.println("postStopVehicle : Van post-stop !");
	}
	
	//Execution Seq : will not be executed at all as Van.stopVehicle() throw and exception and never return normally  
	@AfterReturning("stopVan()")
	public void postReturnStopVehicle() {
		/*will not be executed if exception happened in Van.stopVehicle() execution*/
		System.err.println("postReturnStopVehicle : Van after-Return stop !");
	}
	
	//Execution Seq : 3 as there is exception thrown in the function stopVehicle
	@AfterThrowing("stopVan()")
	public void postThrowingStopVehicle() {
		/*will not be executed if exception happened in Van.stopVehicle() execution*/
		System.err.println("postThrowingStopVehicle : Van after throwing exception in stop !");
	}
	
	
	/*******Gathering After and before in one annotation call instead of putting both annotations above the advise*************/
	@Pointcut("execution(void org.spring5samples.models.Car.stopVehicle())")
	public void stopCar() {
		//stopCar is the id of the pointcut
		//must be named exactly as the joinpoint name 
	}
	
	@Around("stopCar()")
	public void aroundStopVehicle(ProceedingJoinPoint jp) {
		System.err.println("aroundStopVehicle : Car before stop !");
		
			try {
				jp.proceed(); // this will call the joinpoint stopVehicle()
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
		System.err.println("aroundStopVehicle : Car after stop !");
	}
	
	
	/*************Wild Card*******************/
	/*
	 * Usage : 
	 * 
	 * if i have multiple overlaoded functions of the same name   
	 * run() , run(int x) , run(int x ,int y)
	 * 1-Problem : we want to execute an event in case of running any of these overloaded methods
	 * Answer
	 * wild card symbols : 
	 * For Input parameters :
	 * if we put run(*) then it meant the run function which takes one variable of any kind
	 * if we put run(*,*) then it meant the run function which takes 2 variables of any kind
	 * and so on
	 * if we put .. then it meant the run function which takes any number of variables of any kind
	 * For return type :
	 * if we put * then it meant the run function which return any kind
	 * 
	 * 2- problem : if we want to execute an event in case of running any of functions inside a class
	 *    Answer  : put the fully qualified name and replace the function name with *
	 * 3- problem : if we want to execute an event in case of running any of functions inside any class inside specific package
	 *    Answer  : put the fully qualified name and replace the class name and the function name with * 
	*/
	
	@Pointcut("execution(* startCaset(..))")
	public void startCaset() {
	}
	
	@Around("startCaset()")
	public void aroundStartCaset(ProceedingJoinPoint jp) {
		System.err.println("aroundStartCaset : Car before start caset !");
		
			try {
				jp.proceed(); // this will call the joinpoint startCaset
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
		System.err.println("aroundStartCaset : Car after start caset !");
	}
	
	@Pointcut("execution(* org.spring5samples.models.Van.*(..))")
	public void anyInsideVan() {
	}
	
	@Before("anyInsideVan()")
	public void beforeAnyInsideVan() {
		System.err.println("beforeAnyInsideVan : executed!");
	}
	
	/*************PointCut Designators*******************/
	/*
	 * https://docs.spring.io/spring/docs/2.0.x/reference/aop.html
	 * execution   - for matching method execution join points, this is the primary pointcut designator you will use when working with Spring AOP
     * within      - limits matching to join points within certain types (simply the execution of a method declared within a matching type when using Spring AOP)
     * this        - limits matching to join points (the execution of methods when using Spring AOP) where the bean reference (Spring AOP proxy) is an instance of the given type
     * target      - limits matching to join points (the execution of methods when using Spring AOP) where the target object (application object being proxied) is an instance of the given type
     * args        - limits matching to join points (the execution of methods when using Spring AOP) where the arguments are instances of the given types
     * @target     - limits matching to join points (the execution of methods when using Spring AOP) where the class of the executing object has an annotation of the given type
     * @args       - limits matching to join points (the execution of methods when using Spring AOP) where the runtime type of the actual arguments passed have annotations of the given type(s)
     * @within     - limits matching to join points within types that have the given annotation (the execution of methods declared in types with the given annotation when using Spring AOP)
     * @annotation - limits matching to join points where the subject of the join point (method being executed in Spring AOP) has the given annotation 
	*/
	
	
	/*
	 * within - limits matching to join points within certain types (simply the execution of a method declared within a Class or set of classes) 
	 * Accept class org.spring5samples.models.MotorBike
	 * or wild card org.spring5samples.models.*
	*/
	@Pointcut("within (org.spring5samples.models.MotorBike)")
	public void motorBikeFunExec() {
	}
	
	@Before("motorBikeFunExec()")
	public void motorBikeAdvise() {
		System.err.println("motorBikeAdvise : executed!");
	}
	
	/*************JoinPoint Object*******************/
	/*
	 * to get a detailed info about the executed function this Advise run based on it 
	*/
	@Before("execution (void getWheelColor(String))")
	public void wheelColorAdvise(JoinPoint jp) {
		System.err.println("wheelColorAdvise " + jp.toString());
		
		MotorBike motorBike = (MotorBike) jp.getTarget();
	    //reading variable inside the instance
		System.err.println("Max Speed : "+ motorBike.maxSpeed);
		//reading arguments passed to the function
		for (Object arg : jp.getArgs()) {
			System.err.println("Passed Color : "+ arg);
		}
	}
	
	/*************Args*******************/
	/*
	 * execute advise when ever any method with specific type and number of arg
	 * ex. like in  MotorBike >> getMotorColor(String color1,String color2 ,String color3) 
	 * examples :
	 * args(String,String,String) : means any functoin with 3 String arguments executed the advise will be executed  
	 * args(String,..) : means any functoin with first String argument and anykind and number of args executed the advise will be executed 
	*/
	
	@Before("args(String,String,String)")
	public void motorColorAdvise(JoinPoint jp) {
		System.err.println("motorColorAdvise " + jp.toString());
		//reading arguments passed to the function
		for (Object arg : jp.getArgs()) {
					System.err.println("motorColorAdvise Passed Color : "+ arg);
		}
	}
	
	//or we can use args like next for strongly typed var.s
	//for MotorBike >> getMotorCCs(int cc1,int cc2 ,int cc3)
	@Pointcut("args (temp1,temp2,temp3)")
	public void argsFunction(int temp1,int temp2,int temp3) {
	}
	
	//or just remove the above shortcut and put the above expr. in Before directly
	@Before("argsFunction(temp1,temp2,temp3)")
	public void argsFunctionAdvise(int temp1,int temp2,int temp3) {
		System.err.println("argsFunctionAdvise temp1 : "+temp1+" -  temp2 : "+temp2+" -  temp3 : "+temp3);
	}
	
	/*********************This , target , within*************************/
	/* assume we have ElectricCar impl. IElectricVehicle
	 * both  This and target take specific Class or Interface
	 * target   : 
	 		*   if we passed  ElectricCar in the expression
	 			* whenever any method in ElectricCar obj. referenced by ElectricCar or referenced by IElectricVehicle
	 			* then the advice will be executed
	 			 
	 * this     : next behavior will happen only in case (proxyTargetClass = false) , otherwise it will behave exact as target() 
	 		*   if we passed  ElectricCar in the expression
	 			* whenever any method in ElectricCar obj. referenced by ElectricCar only
	 			* then the advice will be executed   
	 			 			 
	 		*   if we passed  IElectricVehicle in the expression
	 			* whenever any method in ElectricCar obj. referenced by IElectricVehicle only
	 			* then the advice will be executed
	 
	 * within   : take a package name 
	 *            the advise will be be executed in every execution of any function inside this package  
	*/
	
	@Before("target(org.spring5samples.models.ElectricBike)")
	public void targetAdvise() {
		System.err.println("targetAdvise Executed");
	}
	
	@Before("this(org.spring5samples.models.IElectricVehicle)")
	public void thisElectricVehicleAdvise() {
		System.err.println("thisElectricVehicleAdvise Executed");
	}
	
	@Before("this(org.spring5samples.models.ElectricBike)")
	public void thisElectricBikeAdvise() {
		System.err.println("thisElectricBikeAdvise Executed");
	}
	
	@Before("within(org.spring5samples.models.*)")
	public void withinModelsAdvise() {
		System.err.println("withinModelsAdvise Executed");
	}
	
	/*********************bean*************************/
	/*
	 * if we want to execute advise when specific bean instantiated
	 * ex. bean(electricBike)  or bean(electric*) or bean(*ctric*)
	*/
	@Before("bean(electricBike)")
	public void beanElectricBikeAdvise() {
		System.err.println("beanElectricBikeAdvise Executed");
	}
	
	/*********************@Target,@Component   Not Working*************************/
	/*
	  * to add more restriction to the advise execution
	  * execute if the target class which contain method that will be executed
	  * contain @component annotation
	*/
	/*
	@Before("@target(org.springframework.stereotype.Component)")
	public void targetComponentAdvise() {
		System.err.println("targetComponentAdvise Executed");
	} 
	*/
	/*********************@annotation,@Deprecated   Not Working*************************/
	//run advise whenever run any deprecated method
	/*
	@Pointcut("@annotation(Deprecated)")
	public void annotationDeprecated() {
		System.err.println("annotationDeprecated Executed");
	}
	
	@Before("annotationDeprecated()")
	public void annotationDeprecatedAdvise() {
		System.err.println("annotationDeprecated Executed");
	}
	
	@Before("@args(Deprecated)")
	public void annotationDeprecated() {
	}
	*/
	/*********************Combining multiple point cut expresstions *************************/
	//run advise whenever run any deprecated method
	//if both matched , the advise will be executed
	
	@Pointcut("target(org.spring5samples.models.ElectricBike)")
	public void pointcutA() {
	}
	
	@Pointcut("target(org.spring5samples.models.ElectricBike)")
	public void pointcutB() {
	}
	
	
	@Before("pointcutA() && !pointcutB()")
	public void ABAdvise() {
		System.err.println("combineABPointCutsAdvise Executed");
	}
}
