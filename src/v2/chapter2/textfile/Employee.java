package v2.chapter2.textfile;

import java.io.Serializable;
import java.time.LocalDate;

public class Employee implements Serializable {

	/**
	 * Employee entity
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", hireDay=" + hireDay + "]";
	}

	private String name;
	private double salary;
	private LocalDate hireDay;
	
	public Employee() {}
	
	public Employee(String name, double salary, int year, int month, int day) {
		this.name =name;
		this.salary = salary;
		this.hireDay = LocalDate.of(year, month, day);
		
	}
	
	public void raiseSalary(double percent) {
		double raise = salary*percent/100;
		salary += raise;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getHireDay() {
		return hireDay;
	}

	public void setHireDay(LocalDate hireDay) {
		this.hireDay = hireDay;
	}
}
