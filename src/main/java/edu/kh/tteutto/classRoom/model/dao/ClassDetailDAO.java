package edu.kh.tteutto.classRoom.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.tteutto.classRoom.model.vo.ClassDetail;


@Repository
public class ClassDetailDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;

	// 클래스 상세페이지 조회
	public ClassDetail selectClassDetail(int classNo) {
		return sqlSession.selectOne("classMapper.selectClassDetail", classNo);
	}
	
	

}
