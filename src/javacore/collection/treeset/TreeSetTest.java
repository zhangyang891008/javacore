package javacore.collection.treeset;

import java.util.TreeSet;

//treesetʵ����navigateableset(�̳���sortedset),ͨ��������������򣬲����ٶȿ죬���ǲ�����Ԫ�ص��ٶȱȽ���
public class TreeSetTest {
	
	public static void main(String[] args) {
		TreeSet<String> set = new TreeSet<>();
		set.add("ac");
		set.add("bc");
		set.add("cc");
		set.add("cc");
		set.add("bd");
		set.add("uu");
		System.out.println(set);
		//no mater whether the element exists
		System.out.println(set.subSet("bda", "uua"));
		System.out.println(set.tailSet("ccc"));
		System.out.println(set.higher("cc"));
		System.out.println(set.lower("cc"));
		System.out.println(set.floor("cc")); //if this element exist, will return the element
		System.out.println(set.ceiling("cc")); //if this element exist, will return the element
		System.out.println(set.descendingSet()); //reverse the set
	}

}
