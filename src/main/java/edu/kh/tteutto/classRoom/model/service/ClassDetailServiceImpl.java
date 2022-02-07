package edu.kh.tteutto.classRoom.model.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.tteutto.classRoom.model.dao.ClassDetailDAO;
import edu.kh.tteutto.classRoom.model.vo.ClassDetailRight;

@Service
public class ClassDetailServiceImpl implements ClassDetailService{

	@Autowired
	private ClassDetailDAO dao;
	

	// 클래스 상세페이지 조회(결제박스만)
	@Override
	public ClassDetailRight selectClassDetail(int classNo) {
		
		ClassDetailRight cdtr = dao.selectClassDetail(classNo);
		
		if( cdtr.getCdt() != null) {
			
			cdtr.setEpSchedule(dao.selectEpisodeSchedule(classNo));
		
		}
				
		
		return cdtr;


	}

	//클래스 신청 여부 조회
	@Override
	public String selectRegisterDt(Map<String, Integer> map) {
		
		return dao.selectRegisterDt(map);
	}
	
	
}
