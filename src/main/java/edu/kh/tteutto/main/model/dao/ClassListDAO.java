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
	
	// 클래스 카드 조회 (메인 페이지)
	public List<ClassList> selectMainList(Map<String, Object> map) {
		System.out.println(map);
		return sqlSession.selectList("classListMapper.selectClassCard", map);
	}
	
	// 클래스 개수 조회
	public int getSearchListCount(Map<String, Object> map) {
		return sqlSession.selectOne("classListMapper.selectClassCount", map);
	}

	// 클래스 카드 조회 (클래스 검색 목록)
	public List<ClassList> selectSearchList(Pagination pagination, Map<String, Object> map) {
		
		if(!map.get("type").equals("hot") && !map.get("type").equals("new")) {
			int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit() ;
			int limit = pagination.getLimit();
			RowBounds rowBounds = new RowBounds(offset, limit);
			
			return sqlSession.selectList("classListMapper.selectClassCard", map, rowBounds);
		}
		else {
			return sqlSession.selectList("classListMapper.selectClassCard", map);
		}
	}
	
	// 클래스 카드 조회 (클래스 검색 목록 검색 결과 X)
	public List<ClassList> selectRecoList(Map<String, Object> map) {
		return sqlSession.selectList("classListMapper.selectClassCard", map);
	}

	// 클래스 테마 이미지 조회
	public List<ClassList> selectThemeImage() {
		return sqlSession.selectList("classListMapper.selectThemeImage");
	}
	
	// 클래스 카드 조회 (클래스 테마 목록)
	public List<ClassList> selectThemeList(Map<String, Object> map) {
		return sqlSession.selectList("classListMapper.selectClassCard", map);
	}
}
