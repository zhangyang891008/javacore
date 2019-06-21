package javacore.iterator.list;

import java.util.ArrayList;
import java.util.ListIterator;

public class ListIteratorTest {
	
	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("a");
		arrayList.add("b");
		arrayList.add("c");
		arrayList.add("d");
		arrayList.add("e");
		ListIterator<String> iterator = arrayList.listIterator();
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.previous());
		iterator.add("x");
		System.out.println("******print");
		print(arrayList);
	}
	
	public static void print(ArrayList<String> list) {
		for (String string : list) {
			System.out.println(string);
		}
	}

}
