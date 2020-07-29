package org.spring5sampledemos.nonpersistent;

import org.springframework.stereotype.Component;

@Component
public class Hatchback implements IBody{

	@Override
	public String type() {
		// TODO Auto-generated method stub
		return "Hatchback";
	}

}
