package org.spring5sampledemos.nonpersistent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Volkswagn implements ICar{

	//as there are multiple body types , means there are several classes implements IBody so we have to be specific from which instance it will take
	//otherwise this will be ambigious
	@Autowired
	@Qualifier("sedan")
	IBody iBody;
	
	@Override
	public String spects() {
		// TODO Auto-generated method stub
		return "Volkswagen with body type : " + iBody.type();
	}

}
