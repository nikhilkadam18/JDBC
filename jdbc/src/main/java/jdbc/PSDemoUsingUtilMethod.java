package jdbc;

import com.pojo.EmployeeDetails;

public class PSDemoUsingUtilMethod {

	public static void main(String[] args) {

		CRUDDemo cd = new CRUDDemo();
		
		System.out.println(cd.getTotalDataCount());
		// Read Employee table
		System.out.println("-----------READ Operation------------");
		//cd.readEmployee();
		
		// Insert Employee
		System.out.println("-----------Write Operation------------");
		EmployeeDetails emp = new EmployeeDetails();
		emp.setEmpid(3);
		emp.setEmpname("ram");
		emp.setEmpcity("banglore");
		//cd.createEmployee(emp);

		System.out.println("-----------Update Operation------------");
		EmployeeDetails empU = new EmployeeDetails();
		empU.setEmpid(3);
		empU.setEmpname("Updated EMployee");
		cd.updateEmployee(empU);
		
		
		//cd.deleteEmployee(4);
		
		
	}
}