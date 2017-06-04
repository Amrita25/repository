package com.springmvc.formvalidation.service;

import java.util.List;

import com.springmvc.formvalidation.model.Student;

public interface StudentService<T> {
	
	void saveStudent(T entity);
	List<Student> findAllStudents();
	boolean removeStudent(long id);
	Student findEntity(long id);
	void updateStudent(Student student);
}
