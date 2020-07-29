package org.spring5sampledemos.nonpersistent;

import org.springframework.stereotype.Component;

@Component
public class Sedan implements IBody{

	@Override
	public String type() {
		// TODO Auto-generated method stub
		return "Sedan";
	}

}
