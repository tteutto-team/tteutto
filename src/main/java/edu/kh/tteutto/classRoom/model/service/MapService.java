package edu.kh.tteutto.classRoom.model.service;

import java.util.List;

import edu.kh.tteutto.classRoom.model.vo.Episode;

public interface MapService {

	/** 전체 지역 불러오기
	 * @return episode
	 */
	List<Episode> classLocation();

}
