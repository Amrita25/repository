package com.springmvc.formvalidation.dao;

import java.util.List;

import com.springmvc.formvalidation.model.Student;

public interface StudentDao<T> {

	void save(T entity);
	List<T> findAll();
	boolean remove(long id);
	Student findById(long id);
	void update(T entity);
}
