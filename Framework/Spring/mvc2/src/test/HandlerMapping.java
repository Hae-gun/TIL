package test;

import java.util.HashMap;

public class HandlerMapping {
	HashMap<String, Controller> mappings;

	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("hello", new HelloController()); // hello�� ���� HelloController�� �����ϰ� mapping
	}

	public Controller getController(String name) {
		return mappings.get(name);
	}
}
