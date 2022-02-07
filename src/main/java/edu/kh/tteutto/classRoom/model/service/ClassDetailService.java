package edu.kh.tteutto.classRoom.model.service;

import java.util.Map;

import edu.kh.tteutto.classRoom.model.vo.ClassDetailRight;

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

}
