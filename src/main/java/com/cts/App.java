package com.cts;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cts.exception.EmployeeAlreadyPresentException;
import com.cts.exception.EmployeeNotFoundException;
import com.cts.model.Employee;
import com.cts.services.EmployeeService;
import com.cts.services.EmployeeServiceImpl;

public class App {
	public static void main(String[] args) {
		int a, id, i = 1;
		String fn, ln, dob, city, country;
		double salary;
		Scanner s = new Scanner(System.in);
		List<Employee> e1 = new ArrayList<Employee>();
		EmployeeService emp = new EmployeeServiceImpl();
		Employee employee = null;
		System.out.println(
				"1.Add Employee \n2.Delete Employee \n3.Update Employee Salary \n4.View All Employee \n5.View Employee by Id");
		try {
			while (i != 0) {
				System.out.println("Enter number for required action:");
				a = s.nextInt();
				switch (a) {
				case 1:
					System.out.println("Enter EmpId:");
					id = s.nextInt();
					System.out.println("Enter First Name:");
					fn = s.next();
					System.out.println("Enter Last Name:");
					ln = s.next();
					System.out.println("Enter Date of Birth(yyyy-mm-dd):");
					dob = s.next();
					System.out.println("Enter city:");
					city = s.next();
					System.out.println("Enter country:");
					country = s.next();
					System.out.println("Enter salary:");
					salary = s.nextDouble();
					employee = new Employee(id, fn, ln, dob, city, country, salary);
					emp.addEmployee(employee);
					System.out.println("Employee added successfully");
					System.out.println("Enter 0 to end and 1 to continue");
					i = s.nextInt();
					break;

				case 2:
					System.out.println("Enter id:");
					id = s.nextInt();
					emp.deleteEmployee(id);
					System.out.println("Employee deleted successfully");
					System.out.println("Enter 0 to end and 1 to continue");
					i = s.nextInt();
					break;

				case 3:
					System.out.println("Enter id:");
					id = s.nextInt();
					System.out.println("Enter salary:");
					salary = s.nextDouble();
					emp.updateEmployee(id, salary);
					System.out.println("Employee salary updated successfully");
					System.out.println("Enter 0 to end and 1 to continue");
					i = s.nextInt();
					break;

				case 4:
					e1 = emp.getAllEmployee();
					for (Employee e : e1) {
						System.out.println(e);
					}
					System.out.println("Enter 0 to end and 1 to continue");
					i = s.nextInt();
					break;

				case 5:
					System.out.println("Enter id:");
					id = s.nextInt();
					employee = emp.getEmployeeById(id);
					System.out.println(employee);
					System.out.println("Enter 0 to end and 1 to continue");
					i = s.nextInt();
					break;

				default:
					System.out.println("Enter number between 1 to 5");
					break;

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch(EmployeeNotFoundException em) {
			System.err.println(em.getMessage());
		}
		catch(EmployeeAlreadyPresentException em) {
			System.err.println(em.getMessage());
		}
	}
}
