package edu.kh.tteutto.main.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.tteutto.main.model.vo.ClassList;
import edu.kh.tteutto.main.model.vo.Pagination;

@Repository
public class ClassListDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// 클래스 개수 조회
	public int getSearchListCount(Map<String, Object> map) {
		return sqlSession.selectOne("classListMapper.selectClassCount", map);
	}

	// 클래스 카드 조회
	public List<ClassList> selectSearchList(Pagination pagination, Map<String, Object> map) {
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit() ;
		int limit = pagination.getLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return sqlSession.selectList("classListMapper.selectClassCard", map, rowBounds);
	}

	
	
	
	
	// 신규 클래스 추천 목록 조회
	public List<ClassList> selectNewList(int memberNo) {
		return sqlSession.selectList("classListMapper.selectNewList", memberNo);
	}

	// 클래스 추천 목록 조회
	public List<ClassList> selectRecoList(int memberNo) {
		return sqlSession.selectList("classListMapper.selectRecoList", memberNo);
	}
}
