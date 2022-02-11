package edu.kh.tteutto.main.model.service;

import java.util.List;
import java.util.Map;

import edu.kh.tteutto.main.model.vo.ClassList;
import edu.kh.tteutto.main.model.vo.Pagination;

public interface ClassListService {
	
	/** 클래스 카드 조회 (메인 페이지)
	 * @param map
	 * @return list
	 */
	List<ClassList> selectMainList(Map<String, Object> map);
	
	/** 클래스 개수 조회
	 * @param map
	 * @param page
	 * @return pagination
	 */
	Pagination getPagination(Map<String, Object> map, int page);
	
	/** 클래스 카드 조회 (클래스 검색 목록)
	 * @param pagination
	 * @param map
	 * @return searchList
	 */
	List<ClassList> selectSearchList(Pagination pagination, Map<String, Object> map);
	
	/** 클래스 카드 조회 (클래스 검색 목록 검색 결과 X)
	 * @param map
	 * @return recommendList
	 */
	List<ClassList> selectRecoList(Map<String, Object> map);

	/** 클래스 테마 이미지 조회
	 * @return themeImage
	 */
	List<ClassList> selectThemeImage();
	
	/** 클래스 카드 조회 (클래스 테마 목록)
	 * @param map
	 * @return themeList
	 */
	List<ClassList> selectThemeList(Map<String, Object> map);
}
