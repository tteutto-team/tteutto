package edu.kh.tteutto.member.model.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.tteutto.member.model.vo.Member;

@Repository
public class LoginDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public Member findkakao(HashMap<String, String> userInfo) {
		
		return sqlSession.selectOne("memberMapper.findkakao",userInfo);
	}

}
