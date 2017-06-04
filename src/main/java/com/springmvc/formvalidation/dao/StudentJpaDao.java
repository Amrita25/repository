package com.springmvc.formvalidation.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Transaction;

import com.springmvc.formvalidation.model.Student;

@Repository
public class StudentJpaDao implements StudentDao<Student>{

	@Autowired
	private SessionFactory factory;
	
	private Session session;
	
	public void save(Student student) {
		getSession().persist(student);
		
	}

	public Session getSession() {
		return factory.getCurrentSession();
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public List<Student> findAll() {
		
		List<Student> allStudents=(List<Student>) getSession().createQuery("from Student").list();
		return allStudents;
	}

	public boolean remove(long id) {
		boolean result=false;
		Student stu=(Student)getSession().load(Student.class, id);
		if(stu!=null){
			getSession().delete(stu);
			result=true;
		}
		return result;
	}

	public Student findById(long id) {
		Student student=(Student)getSession().load(Student.class, id);
		Student finalStudent=new Student(student.getStudentId(), student.getFirstName(), student.getLastName(), student.getGender(),student.getDob(),student.getEmail());
		return finalStudent;
	}
	public void update(Student student){
	//getSession().createQuery("update Student set  )
	}
	
	

}
