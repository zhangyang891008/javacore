package v2.chapter2.textfile;

import java.io.FileInputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * test write data and read data 
 * @author Administrator
 *
 */
public class TextFileTest {
	
	public static void main(String[] args) {
		Employee[] staff = new Employee[3];
		staff[0] = new Employee("harry", 5000, 2019, 5, 10);
		staff[1] = new Employee("carl", 10000, 2018, 5, 4);
		staff[2] = new Employee("Tony", 15000, 2019, 7, 2) ;
		//System.out.println(StandardCharsets.UTF_8.toString());
		//System.out.println(StandardCharsets.UTF_8.displayName());
		
		//write data
		try(PrintWriter out = new PrintWriter("employee.dat", StandardCharsets.UTF_8.displayName())){
			writeData(staff, out);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//read data
		try(Scanner inScanner = new Scanner(new FileInputStream("employee.dat"), StandardCharsets.UTF_8.displayName())){
			staff = readData(inScanner);
			for(Employee employee:staff) {
				System.out.println(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static Employee[] readData(Scanner inScanner) {
		int count =  inScanner.nextInt();
		inScanner.nextLine();
		
		Employee[] staff = new Employee[count]; 
		for(int i = 0; i<count;i++) {
			staff[i] = readEmployee(inScanner);
		}
		return staff;
	}

	private static Employee readEmployee(Scanner inScanner) {
		Employee employee = new Employee();
		String readLine = inScanner.nextLine();
		String[] tokens = readLine.split("\\|");
		employee.setName(tokens[0]);
		employee.setSalary(Double.parseDouble(tokens[1]));
		LocalDate date= LocalDate.parse(tokens[2]);
		LocalDate hireDay = LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth());
		employee.setHireDay(hireDay);
		return employee;
	}

	private static void writeData(Employee[] staff, PrintWriter out) {
		out.println(staff.length);
		for(Employee e:staff) {
			writeEmployee(e, out);
		}
	}

	private static void writeEmployee(Employee e, PrintWriter out) {
		 out.println(e.getName()+"|"+e.getSalary()+"|"+e.getHireDay());
	}
}
