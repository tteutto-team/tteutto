package edu.kh.tteutto.member.model.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import edu.kh.tteutto.member.model.dao.LoginDAO;
import edu.kh.tteutto.member.model.vo.Member;

@Service
public class LoginService {

	@Autowired
	private LoginDAO dao;

	/** 소셜 로그인 회원 확인
	 * @param email
	 * @return loginMember
	 */
	public Member snsLogin(String email) {
		
		Member loginMember = dao.snsLogin(email);
		
		return loginMember;
	}

	/** 소셜 로그인 회원가입
	 * @param member
	 * @return result
	 */
	public int signUp2(Member member) {
		return dao.signUp2(member);
	}

	// sns 이메일 중복 확인
	public int emailCheck(String email) {
		return dao.emailCheck(email);
	}
	
	
}