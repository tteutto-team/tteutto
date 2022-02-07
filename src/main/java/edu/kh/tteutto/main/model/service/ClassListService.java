package edu.kh.tteutto.main.model.service;

import java.util.List;
import java.util.Map;

import edu.kh.tteutto.main.model.vo.ClassList;
import edu.kh.tteutto.main.model.vo.Pagination;

public interface ClassListService {
	
	/** 클래스 개수 조회 + 페이지네이션
	 * @param search
	 * @param page
	 * @return pagination
	 */
	Pagination getPagination(String search, int page);
	
	/** 클래스 카드 목록 조회
	 * @param pagination
	 * @param map
	 * @return searchList
	 */
	List<ClassList> selectSearchList(Pagination pagination, Map<String, Object> map);
}
