package edu.kh.tteutto.classRoom.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.tteutto.classRoom.model.vo.ClassDetail;

@Repository
public class ClassRegisterDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public int classInsert(ClassDetail cdt) {
		return sqlSession.insert("classMapper.classInsert", cdt);
	}
	
}
