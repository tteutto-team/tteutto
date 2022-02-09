package edu.kh.tteutto.classRoom.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.tteutto.classRoom.model.dao.ClassDetailDAO;
import edu.kh.tteutto.classRoom.model.vo.ClassDetailRight;
import edu.kh.tteutto.classRoom.model.vo.ClassRegister;
import edu.kh.tteutto.classRoom.model.vo.ClassReview;
import edu.kh.tteutto.member.model.vo.Member;
import edu.kh.tteutto.classRoom.model.vo.TeacherIntro;
import edu.kh.tteutto.classRoom.model.vo.ThumnailImg;
import edu.kh.tteutto.main.model.vo.ClassList;


@Service
public class ClassDetailServiceImpl implements ClassDetailService{

	@Autowired
	private ClassDetailDAO dao;
	

	// 클래스 상세페이지 조회(결제박스만)
	@Override
	public ClassDetailRight selectClassDetail(int classNo) {
		
		ClassDetailRight cdtr = dao.selectClassDetail(classNo);
		
		
		if( cdtr != null && cdtr.getCdt() != null) {
			
			cdtr.setEpSchedule(dao.selectEpisodeSchedule(classNo));
		
		}
		
		return cdtr;
				
		


	}

	//클래스 신청 여부 조회
	@Override
	public String selectRegisterDt(Map<String, Integer> map) {
		
		return dao.selectRegisterDt(map);
	}

	
	// 후기 평점 조회
	@Override
	public ClassReview selectReviewAvg(int classNo) {
		
		return dao.selectReviewAvg(classNo);
	}

	
	// 결제(신청) 내역 삽입
	@Override
	public int insertRegister(ClassRegister classReg) {
		return dao.insertRegister(classReg);
	}

	
	// 찜목록 추가
	@Override
	public int insertWish(Map<String, Integer> map) {
		return dao.insertWish(map);
	}

	// 찜목록에서 삭제
	@Override
	public int deletetWish(Map<String, Integer> map) {
		return dao.deletetWish(map);
	}

	// 차트 성별 조회
	@Override
	public List<Member> genderChart(int classNo) {
		return dao.genderChart(classNo);
	}

	// 차트 연령대 조회
	@Override
	public List<Member> ageChart(int classNo) {
		return dao.ageChart(classNo);
	}
	
	// 찜 여부
	@Override
	public int selectWishFlag(Map<String, Integer> map) {
		return dao.selectWishFlag(map);
	}

	
	// 강사 소개 조회
	@Override
	public TeacherIntro selectTeacher(int classNo) {
		return dao.selectTeacher(classNo);
	}

	//클래스 썸네일 이미지 조회
	@Override
	public List<ThumnailImg> selectThumImg(int classNo) {
		return dao.selectThumImg(classNo);
	}


	

	
	
}
