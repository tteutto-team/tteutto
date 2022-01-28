package edu.kh.tteutto.classRoom.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int test() {
		
		int result = sqlSession.insert("teacherMapper.test");
		return result;
	}
	
}
