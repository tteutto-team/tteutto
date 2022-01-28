package edu.kh.tteutto.classRoom.model.service;

import org.springframework.beans.factory.annotation.Autowired;

import edu.kh.tteutto.classRoom.model.dao.TeacherDAO;

public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherDAO dao;
	
	@Override
	public int test() {
		return dao.test();
	}
	
}
