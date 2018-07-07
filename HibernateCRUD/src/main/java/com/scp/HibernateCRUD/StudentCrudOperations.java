package com.scp.HibernateCRUD;

import java.util.Collection;
import java.util.List;

public interface StudentCrudOperations {

	public Student getStudent(int id) throws MyException;
	public List<Student> getAllStudents() throws MyException;
	public boolean addStudent(Student s) throws MyException;
	public void addAll(Collection<Student> c) throws MyException;
	public boolean contains(Student s) throws MyException;
	public boolean update(Student s) throws MyException;
	public boolean remove(Student s) throws MyException;
	public void removeAll(Collection<Student> c) throws MyException;
}
