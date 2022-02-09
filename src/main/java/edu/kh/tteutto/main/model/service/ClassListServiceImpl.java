package edu.kh.tteutto.main.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.tteutto.main.model.dao.ClassListDAO;
import edu.kh.tteutto.main.model.vo.ClassList;
import edu.kh.tteutto.main.model.vo.Pagination;

@Service
public class ClassListServiceImpl implements ClassListService {

	@Autowired
	private ClassListDAO dao;
	
	// 클래스 개수 조회
	@Override
	public Pagination getPagination(Map<String, Object> map, int page) {
		int searchListCount = dao.getSearchListCount(map);
		return new Pagination(searchListCount, page);
	}
	
	// 클래스 카드 조회
	@Override
	public List<ClassList> selectSearchList(Pagination pagination, Map<String, Object> map) {
		return dao.selectSearchList(pagination, map);
	}

	
	
	
	
	// 신규 클래스 추천 목록 조회
	@Override
	public List<ClassList> selectNewList(int memberNo) {
		return dao.selectNewList(memberNo);
	}

	// 클래스 추천 목록 조회
	@Override
	public List<ClassList> selectRecoList(int memberNo) {
		return dao.selectRecoList(memberNo);
	}
}
