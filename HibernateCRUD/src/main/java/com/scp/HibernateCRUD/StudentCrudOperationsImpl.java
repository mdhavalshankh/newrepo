package com.scp.HibernateCRUD;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * @author Mahesh
 *
 */
public class StudentCrudOperationsImpl implements StudentCrudOperations {

	SessionFactory factory = Utilities.getSessionFactory();
	Session session = null;

	public Student getStudent(int id) throws MyException {
		if (id <= 0)
			throw new MyException("Please enter valid id. Id cannot be 0 or negative.");
		Student s = null;
		try {
			session = factory.getCurrentSession();
			session.beginTransaction();
			s = session.get(Student.class, id);
		} catch (Exception e) {
			throw new MyException("Exception while getting record.");
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		if (s == null)
			throw new MyException("No student with given id.");
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Student> getAllStudents() throws MyException {

		List<Student> list = new ArrayList<Student>();
		try {
			session = factory.getCurrentSession();
			list = session.createQuery("* from Student").list();
		} catch (Exception e) {
			throw new MyException("Exception while getting records.");
		}
		return list;
	}

	public boolean addStudent(Student s) throws MyException {

		checkObjectForNull(s);
		try {
			session = factory.openSession();
			session.beginTransaction();
			session.save(s);
		} catch (Exception e) {
			throw new MyException("Exception while saving record.");
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		return true;
	}

	public void addAll(Collection<Student> c) throws MyException {

		checkForValidCollection(c);
		try {
			session = factory.getCurrentSession();
			session.beginTransaction();
			for (Student s : c) {
				session.persist(s);
			}
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw new MyException("Student record cannot be null and/or id cannot be 0 or negative.");
		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}

	public boolean contains(Student s) throws MyException {
		Student student = null;
		try {
			session = factory.getCurrentSession();
			session.beginTransaction();
			student = (Student) session.createQuery("* from Student where id = " + s.id);
		} catch (Exception e) {
			throw new MyException("Exception while checking for record.");
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		if (student != null)
			return true;
		else
			return false;
	}

	public boolean update(Student s) throws MyException {

		checkObjectForNull(s);
		try {
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.saveOrUpdate(s);
		} catch (Exception e) {
			throw new MyException("Exception while updating record.");
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		return true;
	}

	public boolean remove(Student s) throws MyException {

		checkObjectForNull(s);
		try {
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.remove(s);
		} catch (Exception e) {
			throw new MyException("Exception while deleting record.");
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		return true;
	}

	public void removeAll(Collection<Student> c) throws MyException {

		checkForValidCollection(c);
		try {
			session = factory.getCurrentSession();
			session.beginTransaction();
			for (Student s : c) {
				session.remove(s);
			}
		} catch (Exception e) {
			throw new MyException("Exception while deleting records.");
		} finally {
			session.getTransaction().commit();
			session.close();
		}

	}

	public static void checkForValidCollection(Collection<Student> c) throws MyException {
		if (c == null)
			throw new MyException("No records found.");
		for (Student s : c) {
			checkObjectForNull(s);
		}
	}

	public static void checkObjectForNull(Student s) throws MyException {
		if (s == null || s.id <= 0)
			throw new MyException("Student record cannot be null and/or id cannot be 0 or negative");
	}
}
