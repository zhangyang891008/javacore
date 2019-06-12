package javacore.singleton;

public enum ESingleton {
	instance("name");
	private String name;
	
	private ESingleton(String name) {
		this.name = name;
	}
	public static ESingleton getInstance() {
		return instance;
	}
}
