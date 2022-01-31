package edu.kh.tteutto.classRoom.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.tteutto.classRoom.model.vo.Episode;

@Repository
public class MapDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<Episode> classLocation() {

		return sqlSession.selectList("teacherMapper.classLocation");
	}
}
