package com.scp.MyMavenProjects.HibernateEmployee;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author Mahesh
 *
 */
public class EmployeeMain {

	Scanner in = new Scanner(System.in);
	SessionFactory factory = new Configuration().configure().buildSessionFactory();
	Session session = factory.openSession();

	public static void main(String[] args) {

		EmployeeMain emain = new EmployeeMain();
		Transaction transaction = emain.session.beginTransaction();
		emain.addEmployee(1, "Mahesh", Profile.DEVELOPER);
		emain.addEmployee(2, "Mahesh", Profile.TESTER);
		emain.addEmployee(3, "Mahesh", Profile.ADMIN);
		transaction.commit();
		emain.session.close();
	}

	void addEmployee(int empId, String empName, Profile profile) {

		if (profile == Profile.DEVELOPER || profile == Profile.TESTER) {
			session.saveOrUpdate(new EmployeeBean(empId, empName, profile));
		}
		else {
			String password = "123";
//			System.out.println("Enter password:");
//			password = in.next();
			session.saveOrUpdate(new AdminBean(empId, empName, password));
		}
	}
}
