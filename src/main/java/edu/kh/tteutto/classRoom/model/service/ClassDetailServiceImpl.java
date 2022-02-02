package edu.kh.tteutto.classRoom.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.tteutto.classRoom.model.dao.ClassDetailDAO;

@Service
public class ClassDetailServiceImpl implements ClassDetailService{

	@Autowired
	private ClassDetailDAO dao;
}
