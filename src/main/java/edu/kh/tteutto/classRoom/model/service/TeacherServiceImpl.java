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
import edu.kh.tteutto.main.model.vo.Pagination;
import edu.kh.tteutto.member.model.vo.Member;

@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherDAO dao;
	
	// 클래스 목록 개수 조회
	@Override
	public Pagination selectClassListCount(int memberNo, int page) {
		int count = dao.selectClassListCount(memberNo);
		return new Pagination(count, page);
	}
	
	// 클래스 목록 조회
	@Override
	public List<ClassDetail> selectClassList(Pagination pagination, int memberNo) {
		return dao.selectClassList(pagination, memberNo);
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
	public List<OngingClass> selectOngoingClass(Pagination pagination, int epNo) {
		return dao.selectOngoingClass(pagination, epNo);
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
	public List<Member> studentListExpect(Pagination pagination, int epNo) {
		return dao.studentListExpect(pagination, epNo);
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
	
	// 학생 수 조회(수강 예정)
	@Override
	public Pagination studentListCount(int epNo, int page) {
		int count = dao.studentListCount(epNo);
		return new Pagination(count, page);
	}
	
	// 학생 수 조회(진행 중)
	@Override
	public Pagination selectOngoingClassListCount(int epNo, int page) {
		int count = dao.selectOngoingClassListCount(epNo).size();
		return new Pagination(count, page);
	}
	
}
