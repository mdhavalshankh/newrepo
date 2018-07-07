package com.scp.HibernateCRUD;

import org.hibernate.Session;

public class TestHibernateCRUD {

	Session session;
	public static void main(String[] args) throws MyException {
				
		Address a1 = new Address(413501, "Osmanabad");
		Student s1 = new Student(1, "Mahesh", a1);
		
		StudentCrudOperations crud = new StudentCrudOperationsImpl();
		
		System.out.println(crud.addStudent(s1));
		//System.out.println(crud.getStudent(1));
		
	}
}
