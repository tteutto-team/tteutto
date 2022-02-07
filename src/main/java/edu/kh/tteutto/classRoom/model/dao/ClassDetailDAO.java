package edu.kh.tteutto.classRoom.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.tteutto.classRoom.model.vo.ClassDetail;
import edu.kh.tteutto.classRoom.model.vo.ClassDetailRight;
import edu.kh.tteutto.classRoom.model.vo.EpisodeSchedule;


@Repository
public class ClassDetailDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;

	// 클래스 상세페이지 조회(결제박스만)
	public ClassDetailRight selectClassDetail(int classNo) {
		return sqlSession.selectOne("classDetailMapper.selectClassDetail", classNo);
	}

	// 클래스 상세페이지 - 회차, 스케쥴 일정 조회
	public List<EpisodeSchedule> selectEpisodeSchedule(int classNo) {
		
		
		return sqlSession.selectList("classDetailMapper.selectEpisodeSchedule", classNo);
	}

	// 클래스 신청 여부 조회
	public String selectRegisterDt(Map<String, Integer> map) {
		return sqlSession.selectOne("classDetailMapper.selectRegisterDt", map);
	}
	
	

}
