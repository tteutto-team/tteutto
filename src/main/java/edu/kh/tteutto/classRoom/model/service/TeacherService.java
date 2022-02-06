package edu.kh.tteutto.classRoom.model.service;

import java.util.List;

import edu.kh.tteutto.classRoom.model.vo.ClassDetail;
import edu.kh.tteutto.classRoom.model.vo.EpisodeClass;

public interface TeacherService {

	/** 클래스 목록 조회
	 * @param memberNo
	 * @return classList
	 */
	List<ClassDetail> selectClassList(int memberNo);

	/** 회차별 클래스 목록 조회
	 * @param classId
	 * @return episodeList
	 */
	List<EpisodeClass> selectClassEpisode(String classId);
	
	
}
