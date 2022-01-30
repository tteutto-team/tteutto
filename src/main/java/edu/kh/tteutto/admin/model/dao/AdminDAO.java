package edu.kh.tteutto.admin.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.tteutto.admin.model.vo.Admin;
import edu.kh.tteutto.admin.model.vo.AdminTeacher;

@Repository
public class AdminDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	
	/** 회차별 목록 조회
	 * @return data
	 */
	public List<Admin> classEpisodeList() {
		return sqlSession.selectList("adminMapper.classEpisodeList");
	}

	
	/** 회차별 신청 승인
	 * @param classNo
	 * @return result
	 */
	public int episodeAgree(int classNo) {
		return sqlSession.update("adminMapper.episodeAgree", classNo);
	}


	/** 회차별 신청 거절
	 * @param classNo
	 * @return result
	 */
	public int episodeDeny(int classNo) {
		return sqlSession.update("adminMapper.episodeDeny", classNo);
	}


	/** 클래스 목록 조회
	 * @return
	 */
	public List<Admin> classList() {
		return sqlSession.selectList("adminMapper.classList");
	}


	/** 클래스 신청 승인
	 * @param classNo
	 * @return result
	 */
	public int classAgree(int classNo) {
		return sqlSession.update("adminMapper.classAgree", classNo);
	}


	/** 클래스 신청 거절
	 * @param classNo
	 * @return result
	 */
	public int classDeny(int classNo) {
		return sqlSession.update("adminMapper.classDeny", classNo);
	}


	/** 강사 목록 조회
	 * @return data
	 */
	public List<AdminTeacher> teacherList() {
		return sqlSession.selectList("adminMapper.teacherList");
	}

	/** 강사 신청 승인
	 * @param memberNo
	 * @return result
	 */
	public int teacherAgree(int memberNo) {
		return sqlSession.update("adminMapper.teacherAgree", memberNo);
	}


	/** 강사 신청 거절
	 * @param memberNo
	 * @return result
	 */
	public int teacherDeny(int memberNo) {
		return sqlSession.update("adminMapper.teacherDeny", memberNo);
	}

	
	/** 강사 정보 조회
	 * @param memberNo
	 * @return teacher
	 */
	public AdminTeacher selectTeacher(int memberNo) {
		return sqlSession.selectOne("adminMapper.selectTeacher", memberNo);
	}


}
