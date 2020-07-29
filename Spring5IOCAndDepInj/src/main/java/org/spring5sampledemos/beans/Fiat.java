package org.spring5sampledemos.beans;

import org.spring5sampledemos.nonpersistent.ICar;

public class Fiat implements ICar{

	String bodyType;
	
	public Fiat() {
		this.bodyType = "Unknown";
	}


	public Fiat(String bodyType) {
		this.bodyType = bodyType;
	}


	@Override
	public String spects() {
		// TODO Auto-generated method stub
		return "Fiat with body type : " + bodyType;
	}

}
