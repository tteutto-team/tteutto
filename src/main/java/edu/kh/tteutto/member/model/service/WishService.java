package edu.kh.tteutto.member.model.service;

import java.util.List;
import java.util.Map;

import edu.kh.tteutto.main.model.vo.ClassList;
import edu.kh.tteutto.main.model.vo.Pagination;

public interface WishService {
	
	/** 클래스 개수 조회
	 * @param page
	 * @return pagination
	 */
	public Pagination getPagination(Map<String, Object> map, int page);
	
	/** 클래스 카드 조회
	 * @param map
	 * @return wishList
	 */
	public List<ClassList> selectWishList(Pagination pagination, Map<String, Object> map);

	/** 찜한 클래스 삽입 & 삭제
	 * @param map
	 * @return heart
	 */
	public int changeHeart(Map<String, Object> map);
}
