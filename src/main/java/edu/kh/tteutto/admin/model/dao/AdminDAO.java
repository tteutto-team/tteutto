package edu.kh.tteutto.admin.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.tteutto.admin.model.vo.Admin;
import edu.kh.tteutto.member.model.vo.Member;

@Repository
public class AdminDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	
	/** 클래스 회차별 목록 조회
	 * @return data
	 */
	public List<Admin> selectList() {
		return sqlSession.selectList("adminMapper.selectList");
	}

	
	/** 회차별 신청 승인
	 * @param classNo
	 * @return result
	 */
	public int agree(int classNo) {
		return sqlSession.update("adminMapper.agree", classNo);
	}

}
