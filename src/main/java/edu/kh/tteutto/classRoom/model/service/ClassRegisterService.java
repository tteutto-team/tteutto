package edu.kh.tteutto.classRoom.model.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import edu.kh.tteutto.classRoom.model.vo.ClassDetail;

public interface ClassRegisterService {

	/** 클래스 등록
	 * @param cdt
	 * @param serverPath 
	 * @param webPath 
	 * @param images 
	 * @return
	 */
	int classInsert(ClassDetail cdt, List<MultipartFile> images, String webPath, String serverPath);
	
}
