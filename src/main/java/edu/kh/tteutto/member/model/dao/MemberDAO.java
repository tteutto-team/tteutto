package edu.kh.tteutto.member.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import edu.kh.tteutto.chat.model.vo.ChatRoom;
import edu.kh.tteutto.classRoom.model.vo.ClassRefund;
import edu.kh.tteutto.classRoom.model.vo.ClassRegister;
import edu.kh.tteutto.classRoom.model.vo.ClassReport;
import edu.kh.tteutto.classRoom.model.vo.ClassReview;
import edu.kh.tteutto.classRoom.model.vo.Teacher;
import edu.kh.tteutto.main.model.vo.ClassList;
import edu.kh.tteutto.main.model.vo.Pagination;
import edu.kh.tteutto.member.model.vo.Career;
import edu.kh.tteutto.member.model.vo.Certified;
import edu.kh.tteutto.member.model.vo.Member;
import edu.kh.tteutto.member.model.vo.Sns;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/** 로그인
	 * @param memberEmail
	 * @return loginMember
	 */
	public Member login(String memberEmail) {
		return sqlSession.selectOne("memberMapper.login", memberEmail);
	}
	
	/** 이메일 중복 검사
	 * @param inputEmail
	 * @return result
	 */
	public int emailDupCheck(String inputEmail) {
		return sqlSession.selectOne("memberMapper.emailDupCheck", inputEmail);
	}
	
	/** 강사 정보 조회
	 * @param memberNo
	 * @return teacher
	 */
	public Teacher selectTeacherProfile(int memberNo) {
		return sqlSession.selectOne("memberMapper.selectTeacherProfile", memberNo);
	}

	/** 강사 이력 조회
	 * @param memberNo
	 * @return career
	 */
	public List<Career> selectTeacherCareer(int memberNo) {
		return sqlSession.selectList("memberMapper.selectTeacherCareer", memberNo);
	}

	/** 강사 sns 조회
	 * @param memberNo
	 * @return snsList
	 */
	public List<Sns> selectTeacherSns(int memberNo) {
		return sqlSession.selectList("memberMapper.selectTeacherSns", memberNo);
	}
	
	/** 회원가입
	 * @param member
	 * @return result
	 */
	public int signUp(Member member) {
		return sqlSession.insert("memberMapper.signUp", member);
	}

	/** 회원 인증테이블에 이메일 중복 확인
	 * @param inputEmail
	 * @return result
	 */
	public int emailDupCheck2(String inputEmail) {
		return sqlSession.selectOne("memberMapper.emailDupCheck2", inputEmail);
	}
	
	/** 회원가입 이메일 인증번호 저장
	 * @param map
	 * @return result
	 */
	public int sendMailTest(Map<String, String> map) {
		return sqlSession.insert("memberMapper.sendMailTest", map);
	}

	/** 회원가입 이메일 인증번호 수정
	 * @param map
	 * @return
	 */
	public int updateMailTest(Map<String, String> map) {
		return sqlSession.update("memberMapper.updateMailTest", map);
	}
	
	/** 이메일 인증 번호 확인
	 * @param map
	 * @return result
	 */
	public int checkCert(Map<String, String> map) {
		return sqlSession.selectOne("memberMapper.checkCert", map);
	}

	public int changeConfirm(Certified certified) {
		return sqlSession.selectOne("memberMapper.changeConfirm", certified);
	}

	public int changePw(Member member) {
		return sqlSession.update("memberMapper.changePw", member);
	}

	public int updateCert(Certified certified) {
		return sqlSession.update("memberMapper.updateCert", certified);
	}

	
	
	
	/** 강사 정보 수정 - 전화번호
	 * @param map1
	 * @return result1
	 */
	public int teacherPhoneUpdate(Map<String, Object> map1) {
		return sqlSession.update("memberMapper.teacherPhoneUpdate", map1);
	}

	/** 강사 정보 수정 - 강사 소개
	 * @param teacher
	 * @return result2
	 */
	public int teacherIntroduceUpdate(Teacher teacher) {
		return sqlSession.update("memberMapper.teacherIntroduceUpdate", teacher);
	}

	/** 강사 정보 수정 - sns 삭제
	 * @param memberNo
	 * @return result3
	 */
	public int teacherSnsDelete(int memberNo) {
		return sqlSession.delete("memberMapper.teacherSnsDelete", memberNo);
	}

	/** 강사 정보 수정 - sns 삽입
	 * @param sns
	 * @return result4
	 */
	public int teacherSnsInsert(Sns sns) {
		return sqlSession.insert("memberMapper.teacherSnsInsert", sns);
	}

	/** 강사 정보 수정 - 이력 삭제
	 * @param memberNo
	 * @return result
	 */
	public int teacherProfileDelete(int memberNo) {
		return sqlSession.delete("memberMapper.teacherProfileDelete", memberNo);
	}

	/** 강사 정보 수정 - 이력 삽입
	 * @param career
	 * @return result
	 */
	public int teacherProfileInsert(Career career) {
		return sqlSession.insert("memberMapper.teacherProfileInsert", career);
	}

	/** 강사 신청
	 * @param teacher
	 * @param career
	 * @param sns
	 * @return
	 */
	public int teacherRegisterInsert(Teacher teacher) {
		return sqlSession.insert("memberMapper.teacherRegisterInsert", teacher);
	}



	/** 이력 삽입
	 * @param career
	 * @return 
	 */
	public int insertTeacherCareer(List<Career> career) {
		return sqlSession.insert("memberMapper.insertTeacherCareer", career);
	}

	/** 강사 이력 삭제
	 * @param id
	 * @return result
	 */
	public int teacherProfiledelete(String id) {
		return sqlSession.insert("memberMapper.teacherProfiledelete", id);
	}

	/** 강사 이력 이미지 조회
	 * @param id
	 * @return selectImgName
	 */
	public String selectImgName(String id) {
		return sqlSession.selectOne("memberMapper.selectImgName", id);
	}

	/** 학생 프로필 수정
	 * @param member
	 * @return result
	 */
	public int studentProfileUpdate(Member member) {
		return sqlSession.update("memberMapper.studentProfileUpdate", member);
	}
	
	/** 회원 탈퇴 조회
	 * @param memberNo
	 * @return result
	 */
	public int selectmemberResign(int memberNo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/** 회원 탈퇴
	 * @param memberNo
	 * @return result
	 */
	public int memberResign(int memberNo) {
		return sqlSession.update("memberMapper.memberResign", memberNo);
	}

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

	// 찜한 클래스 등록
	public int insertHeart(Map<String, Object> map) {
		return sqlSession.insert("classListMapper.insertHeart", map);
	}

	// 찜한 클래스 삭제
	public int deleteHeart(Map<String, Object> map) {
		return sqlSession.delete("classListMapper.deleteHeart", map);
	}

	/** 학생 수강 신청 목록
	 * @param memberNo
	 * @param pagination 
	 * @return register
	 */
	public List<ClassRegister> studentClassList(int memberNo, Pagination pagination) {
		
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		int limit = pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return sqlSession.selectList("memberMapper.studentClassList", memberNo, rowBounds);
	}

	/** 학생 클래스 신고
	 * @param classReport
	 * @return result
	 */
	public int insertReport(ClassReport classReport) {
		return sqlSession.insert("memberMapper.insertReport", classReport);
	}

	
	/** 학생 후기 작성
	 * @param classReview
	 * @return result
	 */
	public int insertComment(ClassReview classReview) {
		return sqlSession.insert("memberMapper.insertReview", classReview);
	}

	/** 학생 작성한 후기 목록
	 * @param memberNo
	 * @param pagination 
	 * @return review
	 */
	public List<ClassReview> studentCommentList(int memberNo, Pagination pagination) {
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		int limit = pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return sqlSession.selectList("memberMapper.studentCommentList", memberNo, rowBounds);
	}

	/** 학생 후기 수정
	 * @param classReview
	 * @return result
	 */
	public int updateReport(ClassReview classReview) {
		return sqlSession.update("memberMapper.updateReview", classReview);
	}

	/** 학생 대 강사 채팅방 생성
	 * @param chatRoom
	 * @return result
	 */
	public int insertChatRoom(ChatRoom chatRoom) {
		return sqlSession.insert("memberMapper.insertChatRoom", chatRoom);
	}


	/** 채팅방이 이미 있는지 확인
	 * @param chatRoom
	 * @return check
	 */
	public int checkChatRoom(ChatRoom chatRoom) {
		return sqlSession.selectOne("memberMapper.checkChatRoom", chatRoom);
	}

	/** 클래스 환불 신청
	 * @param refund
	 * @return result
	 */
	public int refundClass(ClassRefund refund) {
		return sqlSession.insert("memberMapper.refundClass", refund);
	}

	/** 학생 후기 삭제
	 * @param regNo
	 * @return
	 */
	public int deleteReview(int reviewNo) {
		return sqlSession.update("memberMapper.deleteReview", reviewNo);
	}

	/** 후기 있는지 검사
	 * @param regNo
	 * @return result
	 */
	public int searchReview(int regNo) {
		return sqlSession.selectOne("memberMapper.searchReview",regNo);
	}

	/** 신고 있는지 검사
	 * @param regNo
	 * @return result
	 */
	public int searchReport(int regNo) {
		return sqlSession.selectOne("memberMapper.searchReport", regNo);
	}

	/** 환불 신청이 이미 있는지 검사
	 * @param regNo
	 * @return result
	 */
	public int checkRefund(int regNo) {
		return sqlSession.selectOne("memberMapper.checkRefund", regNo);
	}

	/** 내 수강신청 목록 카운트
	 * @param memberNo
	 * @return listCount
	 */
	public int registerCount(int memberNo) {
		return sqlSession.selectOne("memberMapper.registerCount", memberNo);
	}

	public int reviewCount(int memberNo) {
		return sqlSession.selectOne("memberMapper.reviewCount", memberNo);
	}

	public int teacherSt(int memberNo) {
		int result = sqlSession.selectOne("memberMapper.teacherSt", memberNo);
		System.out.println(result);
		return result;
	}

	/** 강사 이미지 수정
	 * @param map
	 * @return result
	 */
	public int teacherImgUpdate(Map<String, String> map) {
		return sqlSession.update("memberMapper.teacherImgUpdate", map);
	}



	
	

}
