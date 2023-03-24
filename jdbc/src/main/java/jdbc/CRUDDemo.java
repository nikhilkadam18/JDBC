package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.utils.DBUtil;
import com.pojo.EmployeeDetails;

public class CRUDDemo {
	
	public int getTotalDataCount() {
		Connection con = DBUtil.getMySQLConnection();
		int count = 0;
		try {
			PreparedStatement ps = con.prepareStatement("SELECT COUNT(empid) as totalEmployee FROM btm.employeedetails WHERE 1=1;");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count; 
	}

	public void readEmployee() {
		Connection con = DBUtil.getMySQLConnection();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM btm.employeedetails;");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createEmployee(EmployeeDetails ed) {
		Connection con = DBUtil.getMySQLConnection();
		try {
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO btm.employeedetails (`empid`, `empname`, `empcity`) VALUES (?,?,?);");
			ps.setInt(1, ed.getEmpid());
			ps.setString(2, ed.getEmpname());
			ps.setString(3, ed.getEmpcity());
			int a = ps.executeUpdate();
			System.out.println(a);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void updateEmployee(EmployeeDetails ed) {
		Connection con = DBUtil.getMySQLConnection();
		try {
			PreparedStatement ps = con.prepareStatement(
					"UPDATE `btm`.`employeedetails` SET `empname` = ? WHERE (`empid` = ?);");
			ps.setString(1, ed.getEmpname());
			ps.setInt(2, ed.getEmpid());
			int a = ps.executeUpdate();
			System.out.println(a);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public void deleteEmployee(int employeeid) {
		Connection con = DBUtil.getMySQLConnection();
		try {
			PreparedStatement ps = con.prepareStatement(
					"DELETE FROM `btm`.`employeedetails` WHERE (`empid` = ?);");
			ps.setInt(1, employeeid);
			int a = ps.executeUpdate();
			System.out.println(a);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}