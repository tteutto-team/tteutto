package edu.kh.tteutto.classRoom.model.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import edu.kh.tteutto.classRoom.model.vo.ClassDetail;
import edu.kh.tteutto.classRoom.model.vo.Episode;
import edu.kh.tteutto.classRoom.model.vo.EpisodeSchedule;

public interface ClassRegisterService {

	/** 클래스 등록
	 * @param cdt
	 * @param serverPath 
	 * @param webPath 
	 * @param images 
	 * @return
	 */
	int classInsert(ClassDetail cdt, List<MultipartFile> images, String webPath, String serverPath);

	/** 스케쥴 등록
	 * @param episode
	 * @param epsList
	 * @return
	 */
	int insertClassSchedule(Episode episode, List<EpisodeSchedule> epsList);

	/** 클래스의 선생 번호 가져오기
	 * @param no
	 * @return teacherNo
	 */
	int teacherNo(int no);

	/** 클래스 가져오기
	 * @param no
	 * @return cdt
	 */
	ClassDetail classSelect(int no);
	
}
