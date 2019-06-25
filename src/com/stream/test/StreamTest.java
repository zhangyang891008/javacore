package com.stream.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
	public static void test() {
		Set<String> list= Stream.of("test","bye","gen","list","test").collect(Collectors.toSet());
		list.stream().forEach(System.out::println);
		Set<Double> set = Stream.generate(Math::random).peek(System.out::println).limit(20).collect(Collectors.toSet());
		//set.stream().forEach(System.out::println);
		Stream.concat(letters("hello"), letters("bye")).forEach(System.out::println);;
		Stream.of("abc","dcdf").flatMap(w->letters(w)).forEach(System.out::println);
		Stream.iterate(1, f->f*2).limit(10).forEach(System.out::println);
		Stream.of("aaa","cab","acc","cac").sorted().forEach(System.out::println);
		Optional<String> optional = Stream.of("aaa","cab","acc","cacbd").filter(s->s.length()>6).findFirst();
		String retString = optional.orElse(new String("empty"));
		System.out.println("ret:"+retString);
		String retString2 = Stream.of("aaa","cab","acc","cac").collect(Collectors.joining(","));
		System.out.println(retString2);
		IntSummaryStatistics length = Stream.of("a","bb","aaa").collect(Collectors.summarizingInt(String::length));
		System.out.println(length.getMax());
	}
	
	public static Stream<String> letters(String str){
		List<String> result = new ArrayList<>();
		for(int i =0; i<str.length();i++) {
			result.add(str.substring(i, i+1));
		}
		return result.stream();
		
	}
	public static void main(String[] args) {
		test();
	}

}
