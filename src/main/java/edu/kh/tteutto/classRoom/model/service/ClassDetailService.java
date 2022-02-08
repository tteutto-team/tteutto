package edu.kh.tteutto.classRoom.model.service;

import java.util.Map;

import org.springframework.ui.Model;

import edu.kh.tteutto.classRoom.model.vo.ClassDetail;
import edu.kh.tteutto.classRoom.model.vo.ClassDetailRight;
import edu.kh.tteutto.classRoom.model.vo.ClassRegister;
import edu.kh.tteutto.classRoom.model.vo.ClassReview;

public interface ClassDetailService {

	/** 클래스 상세페이지 조회
	 * @param classNo
	 * @return classDetailRight
	 */
	ClassDetailRight selectClassDetail(int classNo);

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

}
