package edu.kh.tteutto.classRoom.model.service;

import edu.kh.tteutto.classRoom.model.vo.ClassDetailRight;

public interface ClassDetailService {

	/** 클래스 상세페이지 조회
	 * @param classNo
	 * @return classDetailRight
	 */
	ClassDetailRight selectClassDetail(int classNo);

}
