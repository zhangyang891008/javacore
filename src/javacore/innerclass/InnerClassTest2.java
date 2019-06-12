package javacore.innerclass;

public class InnerClassTest2 {
	public static void main(String[] args) {
		Clock clock = new Clock(4000,true);
		Clock.TimePrinter timer = clock.new TimePrinter();
		System.out.println();
	}
}
