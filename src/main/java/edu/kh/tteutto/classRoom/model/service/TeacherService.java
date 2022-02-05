package edu.kh.tteutto.classRoom.model.service;

import java.util.List;

import edu.kh.tteutto.classRoom.model.vo.ClassDetail;

public interface TeacherService {

	List<ClassDetail> selectClassList(int memberNo);
	
	
}
