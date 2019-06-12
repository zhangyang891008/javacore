package javacore.lambda.compare;

import java.util.Arrays;
import java.util.Comparator;

public class PersonSort {

	public static void main(String[] args) {
		Person person = new Person(null, null);
		Person person1 = new Person("zhang","yang");
		Person person2 = new Person("ma","yang");
		Person person3 = new Person("zhang","guangle");
		Person person4 = new Person("ma","guangle");
		Person[] persons = new Person[5];
		persons[0] = person;
		persons[1] = person1;
		persons[2] = person2;
		persons[3] = person3;
		persons[4] = person4;
		System.out.println("before sort:"+Arrays.toString(persons));
		
		Arrays.sort(persons, Comparator.comparing(Person::getFirstName ,
				Comparator.nullsFirst(Comparator.naturalOrder())));
		System.out.println("after sort:"+Arrays.toString(persons));
		
		Arrays.sort(persons, Comparator.comparing(Person::getFirstName,Comparator.nullsLast(Comparator.naturalOrder()))
				.thenComparing(Person::getLastName, Comparator.nullsLast(Comparator.naturalOrder())));
		System.out.println("after sort2:"+Arrays.toString(persons));
		
	}
 
}
