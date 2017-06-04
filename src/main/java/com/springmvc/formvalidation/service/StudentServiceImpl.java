package com.springmvc.formvalidation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.formvalidation.dao.StudentDao;
import com.springmvc.formvalidation.model.Student;

@Service

public class StudentServiceImpl implements StudentService<Student>{
	
	@Autowired
	private StudentDao dao;

	public StudentDao getDao() {
		return dao;
	}

	public void setDao(StudentDao dao) {
		this.dao = dao;
	}

	@Transactional
	public void saveStudent(Student student) {
		dao.save(student);
		
	}

	@Transactional
	public List<Student> findAllStudents() {
		return dao.findAll();
		
	}

	@Transactional
	public boolean removeStudent(long id) {
		
		return dao.remove(id);
	}
	
	@Transactional
	public void updateStudent(Student student) {
		dao.update(student);

	}
	@Transactional
	public Student findEntity(long id) {
		return dao.findById(id);
	}



}
