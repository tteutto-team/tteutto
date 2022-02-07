package edu.kh.tteutto.classRoom.model.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.tteutto.classRoom.model.dao.TeacherDAO;
import edu.kh.tteutto.classRoom.model.vo.ClassDetail;
import edu.kh.tteutto.classRoom.model.vo.EpisodeClass;

@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherDAO dao;
	
	// 클래스 목록 조회
	@Override
	public List<ClassDetail> selectClassList(int memberNo) {
		return dao.selectClassList(memberNo);
	}
	
	// 회차별 클래스 목록 조회
	@Override
	public List<EpisodeClass> selectClassEpisode(String classId) {
		
		List<EpisodeClass> episodeClassList = dao.selectClassEpisode(classId);
		
		for(EpisodeClass episode : episodeClassList) {
			
		}
		
		return null;
	}
}
