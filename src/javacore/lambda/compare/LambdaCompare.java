package javacore.lambda.compare;

import java.util.Arrays;

public class LambdaCompare {
	
	public static void main(String[] args) {
		String[] colors = {"black","white","yellow","red","blue","green"};
		System.out.println("before sort:"+Arrays.toString(colors));
		Arrays.sort(colors);
		System.out.println("after sort:"+Arrays.toString(colors));
		Arrays.sort(colors, (first, second) -> first.length() - second .length());
		System.out.println("after sort2:"+Arrays.toString(colors));
	}

}
