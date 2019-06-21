package javacore.collection.hashset;

import java.util.HashSet;
import java.util.Scanner;

public class HashSetTest {

	public static void main(String[] args) {
		HashSet<String> word = new HashSet<>();
		boolean finish = false;
		try (Scanner inScanner = new Scanner(System.in)){
			while(!finish && inScanner.hasNext()) {
				String wordString = inScanner.nextLine(); 
				if(wordString.contains("finish")) {
					finish = true;
				}else {
					word.add(wordString);
				}
			}
			
			System.out.println("word size:"+word.size());
			for (String string : word) {
				System.out.println(string);
			}
		} 
	}
}
