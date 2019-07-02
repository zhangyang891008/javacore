package v2.chapter2.objectstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamTest {
	
	public static void main(String[] args) {
		Employee harry = new Employee("harry", 5000, 2019, 5, 10);
		Manager carl = new Manager("carl", 10000, 2018, 5, 4);
		carl.setSecretary(harry);
		Manager tony = new Manager("Tony", 15000, 2019, 7, 2) ;
		tony.setSecretary(harry);
		Employee[] staff = new Employee[3]; 
		staff[0] = harry;
		staff[1] = carl;
		staff[2] = tony;
		//save oject
		try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("employee.dat"))){
			outputStream.writeObject(staff);
		} catch (Exception e) {
			e.printStackTrace();
		}  
		
		try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("employee.dat"))){
			Employee[] employees = (Employee[]) inputStream.readObject();
			for(Employee employee:employees) {
				System.out.println(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
