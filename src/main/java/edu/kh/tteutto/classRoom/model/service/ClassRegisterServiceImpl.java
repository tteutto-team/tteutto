package edu.kh.tteutto.classRoom.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.kh.tteutto.classRoom.model.dao.ClassRegisterDAO;
import edu.kh.tteutto.classRoom.model.vo.ClassDetail;
import edu.kh.tteutto.member.model.dao.MemberDAO;

@Service
public class ClassRegisterServiceImpl implements ClassRegisterService{


	@Autowired
	private ClassRegisterDAO dao;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	// 클래스 등록
	@Override
	public int classInsert(ClassDetail cdt) {
		return dao.classInsert(cdt);
	}
	
}
