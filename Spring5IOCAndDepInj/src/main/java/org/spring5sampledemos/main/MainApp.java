package org.spring5sampledemos.main;

import org.spring5sampledemos.beans.Fiat;
import org.spring5sampledemos.nonpersistent.ICar;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

 	public static void main(String[] args) {
 		
 		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
 		
 		/************ IOC , Dependency Injection , Autowire , Qualifiers ***********/
 		//Dependency Injection and IOC
 		//IOC : Giving the control to spring controller to take an instance from the object for US
 		//getting the injected instance , which been scanned
 		//Dependency Injection : injecting the instance on the business controller or whatever the place based on the requirements  

 		
 		//getting object instance from our Bean factory
 		ICar toyota = appContext.getBean("toyota",ICar.class);
 		System.out.println(toyota.spects()); // this will print 1800 CC	
 		
 		ICar mercedes = appContext.getBean("mercedes",ICar.class);
 		System.out.println(mercedes.spects()); // this will print 1800 CC too 
 		//why not 2200!!!!!!!!!!!!	
 		//Ans. : spring injecting the same engine instance in both objects "Singlton Patteren"
 		//When spring start : it scan components to create instances
 		// scan the components in alphabitical order
 		//- scan Mercedes take an instance , inject engine instance in it , call the constructor >> set the power hourse to 2200
 		//- scan Toyota   take an instance , inject same engine instance in it , call the setEngine >> set the power hourse to 1800
 		//when getting the Mercedes or toyota bean it contains the same engine instance which has default power hourse last updated to 1800 
 		
 		
 		ICar volkswagn = appContext.getBean("volkswagn",ICar.class);
 		System.out.println(volkswagn.spects());
 		
 		
 		
 		//Bad Practice 
 		//Normal Instantiation Method
 		//Don't try to use normal instantiation using new when the class injecting Engine instance inside itself using @Autowired
 		//as in that case of normal instantiation using new the @autowired will just return null
 		//https://stackoverflow.com/questions/19896870/why-is-my-spring-autowired-field-null
 		//https://technology.amis.nl/2018/02/22/java-how-to-fix-spring-autowired-annotation-not-working-issues/
 		
 		//ICar toyota = new Toyota();
 		//System.out.println(toyota.spects());
 		
 		/****** Ends here ******/
 		
 		/************ Beans , Constructor Injection , Optional/Nullable Parameters***********/
 		//getting object instance from our Bean factory
 		//We just annotated the method that will instantiate Fiat class in AppConfig with @Bean
 		//We will not annotate the Fiat class with @Component or anything
 		//Instantiate by calling the default constructor
 		ICar fiat1 = appContext.getBean(Fiat.class);
 		System.out.println(fiat1.spects());
 		
 		
 		//Instantiate by calling the overload constructor
 		ICar fiat2 = appContext.getBean(Fiat.class,"Sedan");
 		System.out.println(fiat2.spects());
 		
 		 	
 		/************/
 		
 		appContext.close();
 	}
}
