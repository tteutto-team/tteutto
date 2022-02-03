package edu.kh.tteutto.classRoom.model.service;

import edu.kh.tteutto.classRoom.model.vo.ClassDetail;

public interface ClassRegisterService {

	/** 클래스 등록
	 * @param cdt
	 * @return
	 */
	int classInsert(ClassDetail cdt);
	
}
