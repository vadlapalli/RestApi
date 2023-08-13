package io.spring;

public class DeiselEngine implements IEngine {
	
	@Override
	public int start() {
		System.out.println("Deisel Engine started");
		return 1;
	}

}
