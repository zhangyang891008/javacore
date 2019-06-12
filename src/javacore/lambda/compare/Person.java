package javacore.lambda.compare;

public class Person {
	
	@Override
	public String toString() {
		 return this.getClass().getName()+"[ firstName:"+ this.firstName +", lastName:" + this.lastName +"]"
				 + System.getProperty("line.separator");
	}

	private String firstName;
	private String lastName;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

}
