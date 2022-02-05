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

	public int getSearchListCount(String search) {
		return sqlSession.selectOne("classListMapper.getSearchListCount", search);
	}

	public List<ClassList> selectSearchList(Pagination pagination, Map<String, Object> map) {
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit() ;
		int limit = pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		
		return sqlSession.selectList("classListMapper.selectSearchList", map, rowBounds);
	}
}
