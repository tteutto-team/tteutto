package edu.kh.tteutto.member.model.service;

import java.util.List;

import edu.kh.tteutto.main.model.vo.ClassList;
import edu.kh.tteutto.main.model.vo.Pagination;

public interface WishService {
	
	/** 클래스 개수 조회 + 페이지네이션
	 * @param page
	 * @return pagination
	 */
	public Pagination getPagination(int memberNo, int page);
	
	/** 클래스 카드 목록 조회
	 * @param memberNo
	 * @return wishList
	 */
	public List<ClassList> selectWishList(Pagination pagination, int memberNo);
}
