package edu.kh.tteutto.member.model.dao;

import java.util.List;

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

	// 클래스 개수 조회 + 페이지네이션
	public int getWishListCount(int memberNo) {
		return sqlSession.selectOne("classListMapper.getWishListCount", memberNo);
	}

	// 클래스 카드 목록 조회
	public List<ClassList> selectWishList(Pagination pagination, int memberNo) {
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit() ;
		int limit = pagination.getLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return sqlSession.selectList("classListMapper.selectWishList", memberNo, rowBounds);
	}
}
