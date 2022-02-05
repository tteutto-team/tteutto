package edu.kh.tteutto.classRoom.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.tteutto.classRoom.model.dao.TeacherDAO;
import edu.kh.tteutto.classRoom.model.vo.ClassDetail;

@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherDAO dao;
	
	@Override
	public List<ClassDetail> selectClassList(int memberNo) {
		return dao.selectClassList(memberNo);
	}
}
