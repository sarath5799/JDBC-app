package com.cts.services;

import java.sql.SQLException;
import java.util.List;

import com.cts.model.Employee;

public interface EmployeeService {
	public void addEmployee(Employee employee) throws SQLException;

	public void deleteEmployee(int id) throws SQLException;

	public void updateEmployee(int id, double salary) throws SQLException;

	public List<Employee> getAllEmployee() throws SQLException;

	public Employee getEmployeeById(int id) throws SQLException;
}
