package edu.kh.tteutto.classRoom.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.tteutto.classRoom.model.dao.TeacherDAO;
import edu.kh.tteutto.classRoom.model.vo.ClassDetail;
import edu.kh.tteutto.classRoom.model.vo.EpisodeClass;
import edu.kh.tteutto.classRoom.model.vo.Receipt;

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
	public List<EpisodeClass> selectClassEpisode(int memberNo) {
		return dao.selectClassEpisode(memberNo);
	}
	
	// 영수증 조회
	@Override
	public List<Receipt> selectReceipt(String epNo) {
		return dao.selectReceipt(epNo);
	}
	
	// 클래스 삭제 가능여부 조회
	@Override
	public int selectDeleteClass(String epNo) {
		return dao.selectDeleteClass(epNo);
	}
	
	// 클래스 삭제
	@Override
	public int deletClass(String epNo) {
		return dao.deletClass(epNo);
	}
}
