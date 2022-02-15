package edu.kh.tteutto.classRoom.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import edu.kh.tteutto.classRoom.model.vo.ClassDetail;
import edu.kh.tteutto.classRoom.model.vo.ClassDetailRight;
import edu.kh.tteutto.classRoom.model.vo.ClassRegister;
import edu.kh.tteutto.classRoom.model.vo.ClassReview;
import edu.kh.tteutto.classRoom.model.vo.ReviewPagination;
import edu.kh.tteutto.member.model.vo.Member;
import edu.kh.tteutto.classRoom.model.vo.TeacherIntro;
import edu.kh.tteutto.classRoom.model.vo.ThumnailImg;
import edu.kh.tteutto.main.model.vo.ClassList;

public interface ClassDetailService {

	/** 클래스 상세페이지 조회
	 * @param map
	 * @return classDetailRight
	 */
	ClassDetailRight selectClassDetail(Map<String, Integer> map);

	/** 클래스 신청 여부 조회
	 * @param map
	 * @return result
	 */
	String selectRegisterDt(Map<String, Integer> map);

	/** 클래스 후기 평점조회
	 * @param classNo
	 * @return classRegister
	 */
	ClassReview selectReviewAvg(int classNo);

	/** 결제(신청) 내역 삽입
	 * @param classReg
	 * @return result
	 */
	int insertRegister(ClassRegister classReg);

	/** 찜목록에 추가
	 * @param map
	 * @return result
	 */
	int insertWish(Map<String, Integer> map);

	/** 찜목록에서 삭제
	 * @param map
	 * @return result
	 */
	int deletetWish(Map<String, Integer> map);


	/** 차트 성별 조회
	 * @param classNo
	 * @return genderChart
	 */
	List<Member> genderChart(int classNo);

	/** 차트 연령대 조회
	 * @param classNo
	 * @return ageChart
	 */
	List<Member> ageChart(int classNo);
	
	/**  찜 여부
	 * @param map
	 * @return result
	 */
	int selectWishFlag(Map<String, Integer> map);

	/** 강사 소개 조회
	 * @param classNo
	 * @return tIntro
	 */
	TeacherIntro selectTeacher(int classNo);

	/** 클래스 썸네일 이미지 조회
	 * @param classNo
	 * @return thumnailImg
	 */
	List<ThumnailImg> selectThumImg(int classNo);

	/** 후기 목록 조회
	 * @param pagination 
	 * @param classNo
	 * @return data
	 */
	List<ClassReview> reviewList(ReviewPagination pagination, int classNo);

	/** 후기 페이징
	 * @param pageNum
	 * @param classNo 
	 * @return pagination
	 */
	ReviewPagination getPagination(int pageNum, int classNo);

	/** 후기 삭제
	 * @param reviewNo
	 * @return result
	 */
	int reviewDelete(int reviewNo);

	/** 후기 수정
	 * @param review
	 * @return result
	 */
	int reviewUpdate(ClassReview review);

	/** 후기 신고하기
	 * @param map
	 * @return result
	 */
	int report(Map<String, Object> map);

	/** 후기 갯수
	 * @param classNo
	 * @return count
	 */
	int reviewCount(int classNo);

	/** 강의 소개 조회
	 * @param classNo
	 * @return cdt
	 */
	ClassDetail selectClassIntro(int classNo);

	
	


}
