package edu.kh.tteutto.classRoom.model.service;

import java.util.List;
import java.util.Map;

import edu.kh.tteutto.classRoom.model.vo.ClassDetail;
import edu.kh.tteutto.classRoom.model.vo.EpisodeClass;
import edu.kh.tteutto.classRoom.model.vo.OngingClass;
import edu.kh.tteutto.classRoom.model.vo.Receipt;
import edu.kh.tteutto.member.model.vo.Member;

public interface TeacherService {

	/** 클래스 목록 조회
	 * @param memberNo
	 * @return classList
	 */
	List<ClassDetail> selectClassList(int memberNo);

	/** 회차별 클래스 목록 조회
	 * @param memberNo
	 * @return episodeList
	 */
	List<EpisodeClass> selectClassEpisode(int memberNo);

	/** 영수증 조회
	 * @param epNo
	 * @return receiptList
	 */
	List<Receipt> selectReceipt(String epNo);

	/** 클래스 삭제 가능여부 조회
	 * @param epNo
	 * @return result
	 */
	int selectDeleteClass(String epNo);

	/** 클래스 삭제
	 * @param epNo
	 * @return result
	 */
	int deletClass(String epNo);

	/** 진행중인 클래스 목록 조회
	 * @param epNo
	 * @return ongoingClassList
	 */
	List<OngingClass> selectOngoingClass(int epNo);

	/** 학생 신고
	 * @param map
	 * @return result
	 */
	int reportStudent(Map<String, String> map);

	/** 정산 신청
	 * @param epNo
	 * @return result
	 */
	int calculate(String epNo);

	/** 클래스 신청 - 기존 클래스 목록 조회
	 * @param memberNo
	 * @return classList
	 */
	List<ClassDetail> existingClassList(int memberNo);

	/** 클래스 교육 예정
	 * @param epNo
	 * @return studentList
	 */
	List<Member> studentListExpect(int epNo);

	/** 수강 거절
	 * @param map
	 * @return result
	 */
	int rejectStudent(Map<String, String> map);

	/** 강사 여부 조회
	 * @param memberNo
	 * @return teacherOK
	 */
	String selectTeacher(int memberNo);

	
}
