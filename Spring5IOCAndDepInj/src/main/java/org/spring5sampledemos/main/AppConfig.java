package org.spring5sampledemos.main;

import org.spring5sampledemos.beans.Fiat;
import org.spring5sampledemos.helpers.StringHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.lang.Nullable;

@Configuration
@ComponentScan("org.spring5sampledemos")
public class AppConfig {
  
  //Bean Scopes : 
  //singleton – 
	//only one instance of the spring bean will be created for the spring container. 
	//This is the default spring bean scope. While using this scope, make sure bean doesn’t have shared instance variables otherwise it might lead to data inconsistency issues.
  //prototype – 
	//A new instance will be created every time the bean is requested from the spring container.
  //request – 
	//This is same as prototype scope, however it’s meant to be used for web applications. A new instance of the bean will be created for each HTTP request.
  //session – 
	//A new bean will be created for each HTTP session by the container.
  //global-session – 
	//This is used to create global session beans for Portlet applications	

  //Tip : in case of parameterized function like the next one 
  //      if it contains required parameters not optional ones  	
  //      if you did not define the scope as prototype or request , the spring will try to take one instance at the start of the app.
  //      and because spring does not know which values to pass , it will through exception 	
	
  @Bean(name = "fiat")
  @Scope("prototype")
  public Fiat fiat(@Nullable String bodyType) {
	  if(StringHelper.isNullOrEmpty(bodyType))
	     return new Fiat();
	  else
	  	 return new Fiat(bodyType);
		  
  }
  
}
