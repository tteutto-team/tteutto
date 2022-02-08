package edu.kh.tteutto.classRoom.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.tteutto.classRoom.model.vo.ClassDetail;
import edu.kh.tteutto.classRoom.model.vo.EpisodeClass;
import edu.kh.tteutto.classRoom.model.vo.OngingClass;
import edu.kh.tteutto.classRoom.model.vo.Receipt;

@Repository
public class TeacherDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// 클래스 조회
	public List<ClassDetail> selectClassList(int memberNo) {
		return sqlSession.selectList("classMapper.selectClassList", memberNo);
	}

	// 회차별 클래스 조회
	public List<EpisodeClass> selectClassEpisode(int memberNo) {
		return sqlSession.selectList("classMapper.selectClassEpisode", memberNo);
	}

	// 영수증 조회
	public List<Receipt> selectReceipt(String epNo) {
		return sqlSession.selectList("classMapper.selectReceipt", epNo);
	}

	// 클래스 삭제 가능여부 조회
	public int selectDeleteClass(String epNo) {
		return sqlSession.selectOne("classMapper.selectDeleteClass", epNo);
	}

	// 클래스 삭제
	public int deletClass(String epNo) {
		return sqlSession.delete("classMapper.deletClass", epNo);
	}

	public List<OngingClass> selectOngoingClass(int epNo) {
		return sqlSession.selectList("classMapper.selectOngoingClass", epNo);
	}

}
