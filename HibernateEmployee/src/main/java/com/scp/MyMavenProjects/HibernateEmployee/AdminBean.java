package com.scp.MyMavenProjects.HibernateEmployee;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="Admin")
public class AdminBean extends EmployeeBean {

	private String password;

	public AdminBean(int empId, String empName, String password) {
		super(empId, empName, Profile.ADMIN);
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", profile=" + profile + ", password=" + password + "]";
	}

}
