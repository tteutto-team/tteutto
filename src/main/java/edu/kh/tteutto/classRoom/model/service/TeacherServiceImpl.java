package edu.kh.tteutto.classRoom.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.tteutto.classRoom.model.dao.TeacherDAO;
import edu.kh.tteutto.classRoom.model.vo.ClassDetail;
import edu.kh.tteutto.classRoom.model.vo.EpisodeClass;
import edu.kh.tteutto.classRoom.model.vo.OngingClass;
import edu.kh.tteutto.classRoom.model.vo.Receipt;
import edu.kh.tteutto.member.model.vo.Member;

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
	
	// 진행중인 클래스 목록 조회
	@Override
	public List<OngingClass> selectOngoingClass(int epNo) {
		return dao.selectOngoingClass(epNo);
	}
	
	// 학생 신고
	@Override
	public int reportStudent(Map<String, String> map) {
		return dao.reportStudent(map);
	}
	
	// 정산 신청
	@Override
	public int calculate(String epNo) {
		return dao.calculate(epNo);
	}
	
	// 클래스 신청 - 기존 클래스 목록 조회
	@Override
	public List<ClassDetail> existingClassList(int memberNo) {
		return dao.existingClassList(memberNo);
	}
	
	// 클래스 교육 예정
	@Override
	public List<Member> studentListExpect(int epNo) {
		return dao.studentListExpect(epNo);
	}
	
	// 수강 거절
	@Override
	public int rejectStudent(Map<String, String> map) {
		int result = 0;
		if(dao.rejectStudent(map) > 0) {
			result = dao.insertMessage(map);
		}
		return result;
	}
	
	// 강사 여부 조회
	@Override
	public String selectTeacher(int memberNo) {
		return dao.selectTeacher(memberNo);
	}
}
