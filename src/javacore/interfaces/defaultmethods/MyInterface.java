package javacore.interfaces.defaultmethods;

public interface MyInterface {
	default void info() {
		System.out.println("myInterface...");
	}
}
