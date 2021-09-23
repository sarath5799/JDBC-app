package com.cts.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cts.dao.EmployeeDAO;
import com.cts.dao.EmployeeDAOImpl;
import com.cts.exception.EmployeeAlreadyPresentException;
import com.cts.exception.EmployeeNotFoundException;
import com.cts.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	EmployeeDAO empDao = new EmployeeDAOImpl();

	public void addEmployee(Employee employee) throws SQLException, EmployeeAlreadyPresentException {
		try {
			empDao.addEmployee(employee);
		} catch (SQLException e) {
			throw new EmployeeAlreadyPresentException("This employee id already exists");
		}
	}

	public void deleteEmployee(int id) throws SQLException {
		int res = empDao.deleteEmployee(id);
		if (res == 0) {
			throw new EmployeeNotFoundException("Employee Not Present ID:" + id);
		}
	}

	public void updateEmployee(int id, double salary) throws SQLException {
		int res = empDao.updateEmployee(id, salary);
		if (res == 0) {
			throw new EmployeeNotFoundException("Employee Not Found ID:" + id);
		}
	}

	public List<Employee> getAllEmployee() throws SQLException {
		List<Employee> emp = new ArrayList<Employee>();
		emp = empDao.getAllEmployee();
		return emp;
	}

	public Employee getEmployeeById(int id) throws SQLException, EmployeeNotFoundException {
		Employee emp = new Employee();
		emp = empDao.getEmployeeById(id);
		if (emp == null) {
			throw new EmployeeNotFoundException("Employee Not Found ID:" + id);
		}
		return emp;
	}

}
