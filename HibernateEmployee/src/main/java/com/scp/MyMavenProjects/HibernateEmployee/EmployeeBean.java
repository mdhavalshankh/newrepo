package com.scp.MyMavenProjects.HibernateEmployee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="Employee")
public class EmployeeBean {

	@Id	
	int empId;
	@Column
	String empName;
	@Enumerated(EnumType.STRING)
	Profile profile;

	public EmployeeBean(int empId, String empName, Profile profile) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.profile = profile;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", profile=" + profile + "]";
	}

}
