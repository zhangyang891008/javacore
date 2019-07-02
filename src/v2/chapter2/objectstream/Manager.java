package v2.chapter2.objectstream;

public class Manager extends Employee {
	private Employee secretary;
	
	public Manager(String name, double salary, int year ,int month ,int day) {
		super(name, salary, year, month, day);
		this.secretary = null;
		
	}

	@Override
	public String toString() {
		return super.toString()+"Manager [secretary=" + secretary + "]";
	}


	public void setSecretary(Employee secretary) {
		this.secretary = secretary;
	}

	public Employee getSecretary() {
		return secretary;
	}
	
	
}
