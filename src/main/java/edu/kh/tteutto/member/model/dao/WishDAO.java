package edu.kh.tteutto.member.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.tteutto.main.model.vo.ClassList;
import edu.kh.tteutto.main.model.vo.Pagination;

@Repository
public class WishDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	// 클래스 개수 조회
	public int getWishListCount(Map<String, Object> map) {
		return sqlSession.selectOne("classListMapper.selectClassCount", map);
	}

	// 클래스 카드 조회
	public List<ClassList> selectWishList(Pagination pagination, Map<String, Object> map) {
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit() ;
		int limit = pagination.getLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return sqlSession.selectList("classListMapper.selectClassCard", map, rowBounds);
	}
}
