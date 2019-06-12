package javacore.reflect;

public class Animal {
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	void description() {
		System.out.println(this.getClass().getName()+":"+this.getName()+","+this.getAge());
	}

}
