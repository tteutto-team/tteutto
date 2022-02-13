package edu.kh.tteutto.classRoom.model.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import edu.kh.tteutto.classRoom.model.vo.ClassDetail;
import edu.kh.tteutto.classRoom.model.vo.Episode;
import edu.kh.tteutto.classRoom.model.vo.EpisodeSchedule;
import edu.kh.tteutto.classRoom.model.vo.IntroImg;

public interface ClassRegisterService {

	/** 클래스 등록
	 * @param cdt
	 * @param serverPath 
	 * @param webPath 
	 * @param images 
	 * @param introImg 
	 * @param introImg 
	 * @return
	 */
	int classInsert(ClassDetail cdt, List<MultipartFile> images, String webPath, String serverPath, List<IntroImg> introImg);

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

	/** 추가 회차 등록인지 체크
	 * @param classNo
	 * @return epCount
	 */
	int checkEpCount(int classNo);

	/** 클래스 원데이 스케쥴 추가
	 * @param episode
	 * @param epsList
	 * @param epCount 
	 * @return result
	 */
	int insertOneClassSchedule(Episode episode, List<EpisodeSchedule> epsList, int epCount);

	/** 정규 재 오픈
	 * @param episode
	 * @param epsList
	 * @param epCount
	 * @return result
	 */
	int insertClassScheduleplus(Episode episode, List<EpisodeSchedule> epsList, int epCount);



}
