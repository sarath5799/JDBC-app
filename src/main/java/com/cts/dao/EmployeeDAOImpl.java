package com.cts.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cts.exception.EmployeeNotFoundException;
import com.cts.model.Employee;
import com.cts.util.DBUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
	public static final String INSERT_SQL = "insert into employees(id,firstname,lastname,date_of_birth,city,country,salary) values(?,?,?,?,?,?,?)";
	public static final String DELETE_SQL = "delete from employees where id=?";
	public static final String UPDATE_SQL = "update employees set salary=? where id=?";

	public int addEmployee(Employee employee) throws SQLException {
		int res=0;
		// Connection
		Connection con = DBUtil.getConnection();
		// create statement
		PreparedStatement ps = con.prepareStatement(INSERT_SQL);
		// Set Parameters
		ps.setInt(1, employee.getId());
		ps.setString(2, employee.getFirstName());
		ps.setString(3, employee.getLastName());
		ps.setString(4, employee.getDateOfBirth());
		ps.setString(5, employee.getCity());
		ps.setString(6, employee.getCountry());
		ps.setDouble(7, employee.getSalary());
		// Execute Statement
		res = ps.executeUpdate();
		return res;
	}

	public int deleteEmployee(int id) throws SQLException {
		Connection con = DBUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(DELETE_SQL);
		ps.setInt(1, id);
		int res = ps.executeUpdate();
		return res;
	}

	public int updateEmployee(int id, double salary) throws SQLException {
		Connection con = DBUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(UPDATE_SQL);
		ps.setDouble(1, salary);
		ps.setInt(2, id);
		int res = ps.executeUpdate();
		return res;
	}

	public List<Employee> getAllEmployee() throws SQLException {
		List<Employee> emp = new ArrayList<Employee>();
		Connection con = DBUtil.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from employees");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Employee e = new Employee();
			e.setId(rs.getInt(1));
			e.setFirstName(rs.getString(2));
			e.setLastName(rs.getString(3));
			e.setDateOfBirth(rs.getString(4));
			e.setCity(rs.getString(5));
			e.setCountry(rs.getString(6));
			e.setSalary(rs.getDouble(7));
			emp.add(e);
		}
		return emp;
	}

	public Employee getEmployeeById(int id) throws SQLException {
		Employee e = null;
		Connection con = DBUtil.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from employees where id=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			e=new Employee();
			e.setId(rs.getInt(1));
			e.setFirstName(rs.getString(2));
			e.setLastName(rs.getString(3));
			e.setDateOfBirth(rs.getString(4));
			e.setCity(rs.getString(5));
			e.setCountry(rs.getString(6));
			e.setSalary(rs.getDouble(7));
		}
		return e;
	}

}
