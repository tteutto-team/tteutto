package edu.kh.tteutto.classRoom.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.tteutto.classRoom.model.dao.TeacherDAO;

@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherDAO dao;
	
	@Override
	public int test() {
		return dao.test();
	}
	
}
