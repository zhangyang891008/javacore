package javacore.reflect;

public class Dog extends Animal{
	private String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public Dog() {
		
	}
	
	private Dog(String color) {
		
	}
	
	@Override
	void description() {
		System.out.println(this.getClass().getName()+":"+this.getAge()+","+this.getName()+","+this.getColor());
	}
}
