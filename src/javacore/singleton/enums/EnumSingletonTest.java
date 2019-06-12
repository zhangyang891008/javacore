package javacore.singleton.enums;

public class EnumSingletonTest {
	
	public static void main(String[] args) {
		ESingleton singleton = ESingleton.getInstance();
		System.out.println(singleton.ordinal());
		ESingleton anotherESingleton = Enum.valueOf(ESingleton.class, "instance");
		System.out.println(anotherESingleton==singleton);
		ESingleton[] valuESingletons = ESingleton.values();
	}
}
