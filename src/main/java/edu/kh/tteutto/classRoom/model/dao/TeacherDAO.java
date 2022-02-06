package edu.kh.tteutto.classRoom.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.tteutto.classRoom.model.vo.ClassDetail;
import edu.kh.tteutto.classRoom.model.vo.EpisodeClass;

@Repository
public class TeacherDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<ClassDetail> selectClassList(int memberNo) {
		return sqlSession.selectList("classMapper.selectClassList", memberNo);
	}

	public List<EpisodeClass> selectClassEpisode(String classId) {
		return sqlSession.selectList("classMapper.selectClassEpisode", classId);
	}
	
}
