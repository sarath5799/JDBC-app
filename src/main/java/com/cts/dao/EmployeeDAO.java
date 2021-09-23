package com.cts.dao;

import java.sql.SQLException;
import java.util.List;

import com.cts.model.Employee;

public interface EmployeeDAO {
	public int addEmployee(Employee employee) throws SQLException;

	public int deleteEmployee(int id) throws SQLException;

	public int updateEmployee(int id, double salary) throws SQLException;

	public List<Employee> getAllEmployee() throws SQLException;

	public Employee getEmployeeById(int id) throws SQLException;
}
